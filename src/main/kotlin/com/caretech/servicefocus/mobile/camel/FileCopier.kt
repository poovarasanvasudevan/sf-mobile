package com.caretech.servicefocus.mobile.camel

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class FileCopier : RouteBuilder() {
    @Throws(Exception::class)
    override fun configure() {
        from("file:D:\\CAMEL\\input?noop=true&readLock=changed&recursive=true")
                .to("file:D:\\CAMEL\\output?autoCreate=true&fileName=\${date:now:yyyyMMdd}/\${file:onlyname.noext}_\${date:now:yyyyMMddHHss}.\${file:ext}")
    }
}
