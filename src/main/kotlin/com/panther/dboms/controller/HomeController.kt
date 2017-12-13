package com.panther.dboms.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 *
 * @author yangfan
 * @since 2017/12/13 17:25
 *
 */
@Controller
class HomeController {

    @GetMapping("/service/home/message")
    @ResponseBody
    fun showHomeMessage(): Map<String, String> {
        return mapOf("success" to "yes", "message" to "success to response the request")
    }
}