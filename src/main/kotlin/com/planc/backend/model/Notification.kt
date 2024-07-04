package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "notifications")
data class Notification(
    @Id
    val id: String? = null,
    val userId: String,
    val type: String,
    val message: String,
    val isRead: Boolean = false,
) : AuditableEntity()
