/**
 * @author yangfan
 * @since 2017/12/15 11:47
 */
package com.panther.dboms.utils

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class DBExecutor(private val conn: Connection) {

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
