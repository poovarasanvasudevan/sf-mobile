package com.caretech.servicefocus.mobile.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun login(): String {
        return "pages/login/index"
    }
}