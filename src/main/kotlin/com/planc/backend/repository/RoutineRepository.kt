package com.planc.backend.repository

import com.planc.backend.model.Routine
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RoutineRepository : MongoRepository<Routine, String> {
    fun findByUserId(userId: String): List<Routine>
    fun findByUserIdAndName(userId: String, name: String): Routine?
}
