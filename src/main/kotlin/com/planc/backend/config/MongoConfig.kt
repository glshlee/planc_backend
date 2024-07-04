package com.planc.backend.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing

@Configuration
@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
class MongoConfig
