package com.caretech.servicefocus.mobile.controller

import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonObject
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping(value = ["/home"])
    fun home(model: Model): String {

        val breadcrump = arrayListOf<JsonObject>()

        breadcrump.add(jsonObject(
                "link" to "/",
                "label" to "Forms"
        ))

        model.addAttribute("breadcrump", breadcrump)
        return "pages/home/index"
    }
}