package com.caretech.servicefocus.mobile.core.interceptor

import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeInterceptor
import java.lang.Exception
import org.springframework.http.server.ServletServerHttpRequest


class HttpHandshakeInterceptor : HandshakeInterceptor {
    override fun afterHandshake(p0: ServerHttpRequest, p1: ServerHttpResponse, p2: WebSocketHandler, p3: Exception?) {
    }

    override fun beforeHandshake(p0: ServerHttpRequest, p1: ServerHttpResponse, p2: WebSocketHandler, p3: MutableMap<String, Any>): Boolean {
        if (p0 is ServletServerHttpRequest) {
            val session = p0.servletRequest.session
            p3["sessionId"] = session.id
        }
        return true
    }
}