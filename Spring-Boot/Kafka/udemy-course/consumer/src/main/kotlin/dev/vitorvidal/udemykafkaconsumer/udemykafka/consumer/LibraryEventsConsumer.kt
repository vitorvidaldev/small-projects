package dev.vitorvidal.udemykafkaconsumer.udemykafka.consumer

import lombok.extern.slf4j.Slf4j
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import java.lang.management.ManagementFactory
import java.lang.management.ThreadInfo
import java.lang.management.ThreadMXBean


@Slf4j
@Component
class LibraryEventsConsumer {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @KafkaListener(topics = ["library-events"], concurrency = "100")
    fun onMessage(consumerRecord: List<ConsumerRecord<String, Any>>, acknowledgment: Acknowledgment?) {
        consumerRecord.forEach {
            log.info("ConsumerRecord: {}", it)
            acknowledgment?.acknowledge()
        }
    }
}