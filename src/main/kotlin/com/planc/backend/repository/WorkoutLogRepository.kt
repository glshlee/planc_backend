package com.planc.backend.repository

import com.planc.backend.model.WorkoutLog
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface WorkoutLogRepository : MongoRepository<WorkoutLog, String> {
    fun findByUserIdAndDateBetween(userId: String, startDate: LocalDate, endDate: LocalDate): List<WorkoutLog>
    fun findByUserIdAndRoutineId(userId: String, routineId: String): List<WorkoutLog>
}
