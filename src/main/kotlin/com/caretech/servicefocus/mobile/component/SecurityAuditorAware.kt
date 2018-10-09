package com.caretech.servicefocus.mobile.component

import com.caretech.servicefocus.mobile.model.User
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.*

@Component
class SecurityAuditorAware : AuditorAware<User> {

    override fun getCurrentAuditor(): Optional<User> {
        val authentication = SecurityContextHolder.getContext().authentication

        return if (authentication == null || !authentication.isAuthenticated) {
            Optional.empty()
        } else Optional.of(authentication.principal as User)
    }
}
