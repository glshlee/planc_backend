package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "feedbacks")
class Feedback(
    @Id
    val id: String? = null,
    val userId: String,
    val routineId: String,
    val rating: Int,
    val comment: String?,
) : AuditableEntity()
