/**
 * @author yangfan
 * @since 2017/12/15 11:47
 */
package com.panther.dboms.utils

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class DBExecutor(private val conn: Connection) {

    fun query(sql: String, setter: PreparedStatement.() -> Unit): QueryResult {
        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        return try {
            ps = conn.prepareStatement(sql)
            ps.setter()
            rs = ps.executeQuery()
            QueryResult(ps, rs)
        } catch (e: SQLException) {
            rs?.close()
            ps?.close()
            throw e
        }
    }

    fun <R> query(sql: String, setter: PreparedStatement.() -> Unit, mapper: ResultSet.() -> R?): R? {
        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        return try {
            ps = conn.prepareStatement(sql)
            ps.setter()
            rs = ps.executeQuery()
            rs.mapper()
        } finally {
            rs?.close()
            ps?.close()
        }
    }

    fun update(sql: String, setter: PreparedStatement.() -> Unit): Int {
        var ps: PreparedStatement? = null
        try {
            ps = conn.prepareStatement(sql)
            ps.setter()
            return ps.executeUpdate()
        } finally {
            ps?.close()
        }
    }

    fun batchUpdate(sql: String, setter: PreparedStatement.() -> Unit): Int {
        var ps: PreparedStatement? = null
        try {
            ps = conn.prepareStatement(sql)
            ps.setter()
            return ps.executeBatch().sum()
        } finally {
            ps?.close()
        }
    }
}

class QueryResult(private val ps: PreparedStatement, private val rs: ResultSet) {
    infix fun <R> mapper(rsMapper: ResultSet.() -> R?): R? {
        return try {
            rs.rsMapper()
        } finally {
            rs.close()
            ps.close()
        }
    }
}
