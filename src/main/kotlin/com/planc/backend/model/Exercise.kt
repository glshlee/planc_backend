package com.planc.backend.model

// import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

// @Entity
@Document(collection = "Exercise")
data class Exercise(
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String,
)
