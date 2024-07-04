package com.planc.backend.model

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.context.SecurityContextHolderStrategy
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class SpringSecurityAuditorAware(
    private val securityContextHolderStrategy: SecurityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy(),
) : AuditorAware<String> {

    override fun getCurrentAuditor(): Optional<String> {
        return Optional.ofNullable(securityContextHolderStrategy.context.authentication)
            .filter { it.isAuthenticated }
            .map { it.principal }
            .map { principal ->
                when (principal) {
                    is UserDetails -> principal.username
                    is String -> principal
                    else -> "anonymousUser"
                }
            }
            .or { Optional.of("anonymousUser") }
    }
}
