package com.demo.leonovets.rabbitmqproducer.repository.entity

import org.springframework.data.annotation.Id
import reactor.core.publisher.Mono
import java.time.LocalDateTime

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
open class Entity(
    @Id
    private var id: String? = null,
    private var createdAt: LocalDateTime? = null,
    private var deletedAt: LocalDateTime? = null
) {
    fun isDeleted() = if (deletedAt != null) {
        Mono.just(true)
    } else {
        Mono.just(false)
    }
}
