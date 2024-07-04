package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "workoutLogs")
class WorkoutLog(
    @Id
    val id: String? = null,
    val userId: String,
    val routineId: String,
    val date: LocalDate,
    val completedWorkouts: List<CompletedWorkout>,
    val notes: String?,
) : AuditableEntity()

class CompletedWorkout(
    val workoutId: String,
    val sets: Int,
    val reps: Int,
    val duration: Int?,
    val weight: Double?,
) : AuditableEntity()
