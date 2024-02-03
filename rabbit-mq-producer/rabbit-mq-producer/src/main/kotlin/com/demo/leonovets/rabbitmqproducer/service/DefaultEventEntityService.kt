package com.demo.leonovets.rabbitmqproducer.service

import com.demo.leonovets.rabbitmqproducer.repository.EventEntityRepository
import com.demo.leonovets.rabbitmqproducer.repository.entity.EventEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
@Service
class DefaultEventEntityService(
    private val eventEntityRepository: EventEntityRepository
) : EventEntityService {
    override fun save(eventEntity: EventEntity): Mono<EventEntity> {
        eventEntity.createdAt = LocalDateTime.now()
        return eventEntityRepository.save(eventEntity)
    }

    override fun findAll() = eventEntityRepository.findAll()

    override fun findById(id: String) = eventEntityRepository.findById(id)

    override fun deleteById(id: String): Mono<Void> {
        return eventEntityRepository.findById(id).map {
            it.deletedAt = LocalDateTime.now()
            eventEntityRepository.save(it)
        }.then()
    }

}
