package com.demo.leonovets.rabbitmqproducer.route

import com.demo.leonovets.rabbitmqproducer.handler.EventEntityHandler
import com.demo.leonovets.rabbitmqproducer.handler.impl.DefaultEventEntityHandler
import com.demo.leonovets.rabbitmqproducer.service.EventEntityService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.DELETE
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.POST
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

/**
 *
 * @author Mikhail.Leonovets
 * @since 01/2024
 */
@Configuration
class EventEntityRouterConfig {
    @Bean
    fun eventEntityHandler(eventEntityService: EventEntityService): EventEntityHandler {
        return DefaultEventEntityHandler(eventEntityService)
    }

    @Bean
    fun eventEntityRouter(handler: EventEntityHandler): RouterFunction<ServerResponse> {
        return route(POST("/event-entity"), handler::handleSave)
            .andRoute(GET("/event-entity"), handler::handleFindAll)
            .andRoute(GET("/event-entity/{id}"), handler::handleFindById)
            .andRoute(DELETE("/event-entity/{id}"), handler::handleDeleteById)
    }
}