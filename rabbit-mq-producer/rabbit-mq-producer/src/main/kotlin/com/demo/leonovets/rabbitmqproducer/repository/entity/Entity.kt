package com.demo.leonovets.rabbitmqproducer.repository.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import reactor.core.publisher.Mono
import java.time.LocalDateTime

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
open class Entity(
    @Id
    open val id: ObjectId = ObjectId(),
    @Field("created-at")
    open var createdAt: LocalDateTime? = null,
    @Field("deleted-at")
    open var deletedAt: LocalDateTime? = null
) {
    fun isDeleted() = if (deletedAt != null) {
        Mono.just(true)
    } else {
        Mono.just(false)
    }
}
