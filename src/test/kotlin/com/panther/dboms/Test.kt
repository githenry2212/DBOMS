package com.panther.dboms

import java.net.URLDecoder

/**
 *
 * @author yangfan
 * @since 2017/12/13 17:20
 *
 */
fun main(args: Array<String>) {
    val s = "http://errors.angularjs.org/1.6.6/${'$'}injector/modulerr?p0=omsApp&p1=ReferenceError%3A%20omsJsLoader%20is%20not%20defined%0A%20%20%20%20at%20http%3A%2F%2Flocalhost%3A8080%2Fjs%2Froute.js%3A11%3A20%0A%20%20%20%20at%20Object.invoke%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A44%3A357)%0A%20%20%20%20at%20d%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A42%3A237)%0A%20%20%20%20at%20http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A42%3A376%0A%20%20%20%20at%20p%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A8%3A7)%0A%20%20%20%20at%20g%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A42%3A138)%0A%20%20%20%20at%20hb%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A46%3A250)%0A%20%20%20%20at%20c%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A22%3A19)%0A%20%20%20%20at%20Uc%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A22%3A332)%0A%20%20%20%20at%20we%20(http%3A%2F%2Flocalhost%3A8080%2Fcommon%2Fjs%2Fangular%2F1.6.6%2Fangular.min.js%3A21%3A1)"
    println(URLDecoder.decode(s,"UTF-8"))
}