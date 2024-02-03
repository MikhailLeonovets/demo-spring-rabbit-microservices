package com.demo.leonovets.rabbitmqproducer.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
interface EventEntityHandler {
    fun handleSave(request: ServerRequest): Mono<ServerResponse>

    fun handleFindAll(request: ServerRequest): Mono<ServerResponse>

    fun handleFindById(request: ServerRequest): Mono<ServerResponse>

    fun handleDeleteById(request: ServerRequest): Mono<ServerResponse>
}