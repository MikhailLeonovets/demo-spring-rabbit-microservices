package com.demo.leonovets.rabbitmqproducer.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
@Document(collection = "event-entity-db")
data class EventEntity(
    @Id private val id: String?,
    val message: String,
    var createdAt: LocalDateTime?,
    var deletedAt: LocalDateTime?
) : Entity(id, createdAt, deletedAt)
