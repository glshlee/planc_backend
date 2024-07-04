package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime

@Document(collection = "users")
class User(
    @Id
    val id: String? = null,
    val email: String,
    val passwordHash: String,
    val name: String,
    val dateOfBirth: LocalDate,
    val gender: String,
    val height: Double,
    val weight: Double,
    val fitnessLevel: String,
    val goals: List<String>,
    val availableEquipment: List<String>,
    val preferredWorkoutDays: List<String>,
    val workoutDurationPreference: Int,
    val healthConditions: List<String>
) : AuditableEntity() {
    // 필요한 경우 equals(), hashCode(), toString() 메서드를 오버라이드합니다.
}