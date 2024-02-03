package com.demo.leonovets.rabbitmqproducer.handler.impl

import com.demo.leonovets.rabbitmqproducer.handler.EventEntityHandler
import com.demo.leonovets.rabbitmqproducer.repository.entity.EventEntity
import com.demo.leonovets.rabbitmqproducer.service.EventEntityService
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
class DefaultEventEntityHandler(
    private val eventEntityService: EventEntityService
) : EventEntityHandler {
    override fun handleSave(request: ServerRequest): Mono<ServerResponse> {
        val eventEntity = request.bodyToMono(EventEntity::class.java)
        return eventEntity.flatMap {
            ServerResponse.ok().build(eventEntityService.save(it).then())
        }
    }

    override fun handleFindAll(request: ServerRequest) = ServerResponse.ok().body(eventEntityService.findAll(), EventEntity::class.java)

    override fun handleFindById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        return ServerResponse.ok()
            .body(eventEntityService.findById(id))
            .switchIfEmpty(ServerResponse.notFound().build())
    }

    override fun handleDeleteById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        // todo
        return ServerResponse.ok().build()
    }
}