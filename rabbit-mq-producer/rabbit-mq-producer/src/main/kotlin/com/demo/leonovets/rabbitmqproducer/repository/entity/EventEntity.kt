package com.demo.leonovets.rabbitmqproducer.repository.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
@Document(collection = "event-entity")
data class EventEntity(
    override val id: ObjectId = ObjectId(),
    val message: String,
    override var createdAt: LocalDateTime?,
    override var deletedAt: LocalDateTime?
) : Entity(id, createdAt, deletedAt)
