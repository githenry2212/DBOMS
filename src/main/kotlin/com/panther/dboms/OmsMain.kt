package com.panther.dboms

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 *
 * @author yangfan
 * @since 2017/12/13 17:17
 *
 */
@SpringBootApplication
open class OmsMain

fun main(args: Array<String>) {
    SpringApplication.run(OmsMain::class.java, *args)
}