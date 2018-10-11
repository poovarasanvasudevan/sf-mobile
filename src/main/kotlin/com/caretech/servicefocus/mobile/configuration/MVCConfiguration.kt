package com.caretech.servicefocus.mobile.configuration

import com.caretech.servicefocus.mobile.core.interceptor.PoweredByInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MVCConfiguration : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(PoweredByInterceptor())
    }

}
