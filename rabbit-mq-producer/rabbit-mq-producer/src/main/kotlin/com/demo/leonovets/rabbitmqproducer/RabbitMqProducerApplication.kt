package com.demo.leonovets.rabbitmqproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitMqProducerApplication

fun main(args: Array<String>) {
	runApplication<RabbitMqProducerApplication>(*args)
}
