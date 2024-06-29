package com.planc.backend.repository

import com.planc.backend.model.Exercise
import org.springframework.data.mongodb.repository.MongoRepository

// @Repository
// interface ExerciseRepository : JpaRepository<Exercise, Long>

interface ExerciseRepository : MongoRepository<Exercise, String>
