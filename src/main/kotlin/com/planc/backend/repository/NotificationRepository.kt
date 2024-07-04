package com.planc.backend.repository

import com.planc.backend.model.Notification
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository : MongoRepository<Notification, String> {
    fun findByUserIdAndIsReadFalse(userId: String): List<Notification>
    fun countByUserIdAndIsReadFalse(userId: String): Long
}
