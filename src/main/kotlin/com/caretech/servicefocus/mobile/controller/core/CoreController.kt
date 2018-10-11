package com.caretech.servicefocus.mobile.controller.core

import com.google.gson.JsonElement
import com.google.gson.JsonParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/core")
class CoreController @Autowired
constructor(internal val jdbcTemplate: JdbcTemplate) {

    @GetMapping("/list" , produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getList(@RequestParam key: String): JsonElement? {
        val js =  jdbcTemplate.queryForObject(String.format("SELECT get_list('%1\$s')", key), String::class.java)
        return JsonParser().parse(js)
    }
}
