package dev.vitorvidal.udemykafkaproducer.udemykafka.component

import com.fasterxml.jackson.databind.ObjectMapper
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LibraryEventProducer(val kafkaTemplate: KafkaTemplate<Int, String>, val objectMapper: ObjectMapper) {
    fun sendLibraryEvent(libraryEvent: LibraryEvent) {
        val key = libraryEvent.libraryEventId
        val value = objectMapper.writeValueAsString(libraryEvent)
        kafkaTemplate.sendDefault(key, value)
    }
}