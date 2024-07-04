package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "routines")
class Routine(
    @Id
    val id: String? = null,
    val userId: String,
    val name: String,
    val description: String,
    val workouts: List<RoutineWorkout>,
) : AuditableEntity()

class RoutineWorkout(
    val workoutId: String,
    val sets: Int,
    val reps: Int,
    val duration: Int?,
    val restTime: Int,
) : AuditableEntity()
