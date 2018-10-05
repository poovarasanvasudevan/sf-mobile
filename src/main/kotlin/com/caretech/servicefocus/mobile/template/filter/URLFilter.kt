package com.caretech.servicefocus.mobile.template.filter

import com.mitchellbosecke.pebble.extension.Filter
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

class URLFilter : Filter {
    override fun apply(p0: Any?, p1: MutableMap<String, Any>?): Any? {
        if (p0 == null) {
            return null
        } else {
            return UriComponentsBuilder
                    .fromUriString(p0.toString())
                    .queryParam("_key", Date().time)
                    .build()
                    .toUriString()

        }
    }

    override fun getArgumentNames(): MutableList<String>? = null
}