package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "workouts")
class Workout(
    @Id
    val id: String? = null,
    val name: String,
    val description: String,
    val type: String,
    val difficulty: String,
    val muscleGroups: List<String>,
    val equipment: List<String>,
    val instructions: List<String>,
    val imageUrl: String?,
    val videoUrl: String?,
) : AuditableEntity()
