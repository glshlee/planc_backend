package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "users")
class User(
    @Id
    val id: String? = null,
    val email: String,
    var password: String,
    var name: String,
    val dateOfBirth: LocalDate,
    val gender: String,
    var height: Double,
    var weight: Double,
    var fitnessLevel: String,
    var goals: List<String>,
    var availableEquipment: List<String>,
    var preferredWorkoutDays: List<String>,
    var workoutDurationPreference: Int,
    var healthConditions: List<String>,
) : AuditableEntity()
