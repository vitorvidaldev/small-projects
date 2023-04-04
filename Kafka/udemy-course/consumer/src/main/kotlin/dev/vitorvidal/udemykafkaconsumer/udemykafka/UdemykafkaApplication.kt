package dev.vitorvidal.udemykafkaconsumer.udemykafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class UdemykafkaApplication

fun main(args: Array<String>) {
	runApplication<UdemykafkaApplication>(*args)
}
