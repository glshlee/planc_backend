package com.planc.backend.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongoConfig : AbstractMongoClientConfiguration() {

    @Value("\${MONGODB_URI}")
    lateinit var mongoUri: String

    override fun getDatabaseName(): String {
        return "planc"
    }

    @Bean
    override fun mongoClient(): MongoClient {
        return MongoClients.create(mongoUri)
    }
}
