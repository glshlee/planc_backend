package com.planc.backend.repository

import com.planc.backend.model.ProgressTracking
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ProgressTrackingRepository : MongoRepository<ProgressTracking, String> {
    fun findByUserIdOrderByDateDesc(userId: String): List<ProgressTracking>
    fun findByUserIdAndDateBetween(userId: String, startDate: LocalDate, endDate: LocalDate): List<ProgressTracking>
}
