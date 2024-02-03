package com.demo.leonovets.rabbitmqproducer.service

import com.demo.leonovets.rabbitmqproducer.repository.entity.EventEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
interface EventEntityService {

    fun save(eventEntity: EventEntity): Mono<EventEntity>

    fun findAll(): Flux<EventEntity>

    fun findById(id: String): Mono<EventEntity>

    fun deleteById(id: String): Mono<Void>
}