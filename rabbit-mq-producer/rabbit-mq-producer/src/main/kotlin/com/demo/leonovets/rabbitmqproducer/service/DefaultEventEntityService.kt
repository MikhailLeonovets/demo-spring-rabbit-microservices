package com.demo.leonovets.rabbitmqproducer.service

import com.demo.leonovets.rabbitmqproducer.repository.EventEntityRepository
import com.demo.leonovets.rabbitmqproducer.repository.entity.EventEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
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
    private val logger = LoggerFactory.getLogger(DefaultEventEntityService::class.java)

    override fun save(eventEntity: EventEntity): Mono<EventEntity> {
        logger.info("Saving new EventEntity")
        eventEntity.createdAt = LocalDateTime.now()
        return eventEntityRepository.save(eventEntity)
    }

    override fun findAll(): Flux<EventEntity> {
        logger.info("Finding all EventEntity")
        return eventEntityRepository.findAll()
    }

    override fun findById(id: String): Mono<EventEntity> {
        logger.info("Finding by id $id EventEntity")
        return eventEntityRepository.findById(id)
    }

    override fun deleteById(id: String): Mono<Void> {
        logger.info("Deleting by id $id EventEntity")
        return eventEntityRepository.findById(id).map {
            it.deletedAt = LocalDateTime.now()
            return@map it
        }.zipWhen {
            eventEntityRepository.save(it)
        }.then()
    }

}
