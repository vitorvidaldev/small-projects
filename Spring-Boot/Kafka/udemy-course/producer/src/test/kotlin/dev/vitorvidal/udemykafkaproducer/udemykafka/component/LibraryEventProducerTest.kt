package dev.vitorvidal.udemykafkaproducer.udemykafka.component

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.kafka.core.KafkaTemplate

@ExtendWith(MockitoExtension::class)
class LibraryEventProducerTest {
    @InjectMocks
    lateinit var eventProducer: LibraryEventProducer

    @Mock
    lateinit var kafkaTemplate: KafkaTemplate<Int, String>

    val objectMapper = ObjectMapper()
}