package com.planc.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "progressTracking")
class ProgressTracking(
    @Id
    val id: String? = null,
    val userId: String,
    val date: LocalDate,
    val weight: Double,
    val bodyFatPercentage: Double?,
    val measurements: Measurements?,
) : AuditableEntity()

class Measurements(
    val chest: Double?,
    val waist: Double?,
    val hips: Double?,
    val biceps: Double?,
    val thighs: Double?,
) : AuditableEntity()
