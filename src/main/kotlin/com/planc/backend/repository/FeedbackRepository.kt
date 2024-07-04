package com.planc.backend.repository

import com.planc.backend.model.Feedback
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedbackRepository : MongoRepository<Feedback, String> {
    fun findByRoutineId(routineId: String): List<Feedback>
    fun findByUserId(userId: String): List<Feedback>
}
