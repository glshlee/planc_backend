package com.planc.backend.repository

import com.planc.backend.model.Challenge
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ChallengeRepository : MongoRepository<Challenge, String> {
    fun findByStartDateAfter(date: LocalDate): List<Challenge>
    fun findByParticipantsContaining(userId: String): List<Challenge>
}
