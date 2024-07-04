package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "challenges")
class Challenge(
    @Id
    val id: String? = null,
    val name: String,
    val description: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val workouts: List<String>,
    val participants: List<String>,
) : AuditableEntity()
