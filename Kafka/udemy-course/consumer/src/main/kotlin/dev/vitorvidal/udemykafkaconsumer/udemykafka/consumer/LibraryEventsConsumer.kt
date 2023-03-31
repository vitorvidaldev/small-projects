package dev.vitorvidal.udemykafkaconsumer.udemykafka.consumer

import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Slf4j
@Component
class LibraryEventsConsumer {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @KafkaListener(topics = ["library-events"])
    fun onMessage(consumerRecord: List<Any>, acknowledgment: Acknowledgment?) {
        log.info("ConsumerRecord: {}", consumerRecord)
        acknowledgment?.acknowledge()
    }
}