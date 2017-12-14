/**
 *
 * @author yangfan
 * @since 2017/12/14 17:17
 *
 */
package com.panther.dboms.sql

interface Element {
    fun render(builder: StringBuilder)
}

class TextElement(private val text: String) : Element {
    override fun render(builder: StringBuilder) {
        builder.append(text)
    }
}

@DslMarker
annotation class SQLTagMarker

@SQLTagMarker
abstract class Tag(private val name: String) : Element {
    val children = arrayListOf<Element>()

    override fun render(builder: StringBuilder) {
        builder.append(name).append(' ')
        for (idx in children.indices) {
            val child = children[idx]
            child.render(builder)
            if (this is SELECT && child is TextElement) {
                val next = (if (idx + 1 < children.size) children[idx + 1] else null) ?: break
                if (next is FROM) builder.append(' ') else builder.append(',')
            } else if (idx < children.size - 1) {
                when (child) {
                    is FROM, is WHERE, is GROUPBY, is HAVING, is ORDERBY -> builder.append(' ')
                    else -> if (this is WHERE || this is HAVING) builder.append(" AND ") else builder.append(',')
                }
            }
        }
    }

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class SELECT : TagWithText("SELECT") {
    fun from(init: FROM.() -> Unit) = initTag(FROM(), init)
    fun where(init: WHERE.() -> Unit) = initTag(WHERE(), init)
    fun groupby(init: GROUPBY.() -> Unit) = initTag(GROUPBY(), init)
    fun having(init: HAVING.() -> Unit) = initTag(HAVING(), init)
    fun orderby(init: ORDERBY.() -> Unit) = initTag(ORDERBY(), init)
}

class FROM : TagWithText("FROM")
class WHERE : TagWithText("WHERE")
class GROUPBY : TagWithText("GROUP BY")
class HAVING : TagWithText("HAVING")
class ORDERBY : TagWithText("ORDER BY")

fun select(init: SELECT.() -> Unit): SELECT {
    val sql = SELECT()
    sql.init()
    return sql
}