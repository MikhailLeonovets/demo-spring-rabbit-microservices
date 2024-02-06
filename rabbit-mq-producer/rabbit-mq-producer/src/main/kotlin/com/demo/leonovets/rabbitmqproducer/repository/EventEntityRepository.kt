package com.demo.leonovets.rabbitmqproducer.repository

import com.demo.leonovets.rabbitmqproducer.repository.entity.EventEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
@Repository
interface EventEntityRepository : ReactiveMongoRepository<EventEntity, String>
