package com.planc.backend.repository

import com.planc.backend.model.Workout
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkoutRepository : MongoRepository<Workout, String> {
    fun findByType(type: String): List<Workout>
    fun findByDifficulty(difficulty: String): List<Workout>
    fun findByMuscleGroupsContaining(muscleGroup: String): List<Workout>
}
