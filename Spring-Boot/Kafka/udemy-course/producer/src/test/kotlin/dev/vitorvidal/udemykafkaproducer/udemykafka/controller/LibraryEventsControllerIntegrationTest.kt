package dev.vitorvidal.udemykafkaproducer.udemykafka.controller

import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.Book
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEvent
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEventType
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.common.serialization.IntegerDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.exchange
import org.springframework.http.*
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.test.context.TestPropertySource

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = ["library-events"], partitions = 1)
@TestPropertySource(
    properties = [
        "spring.kafka.producer.bootstrap-servers=\${spring.embedded.kafka.brokers}",
        "spring.kafka.admin.properties.bootstrap.servers=\${spring.embedded.kafka.brokers}"
    ]
)
class LibraryEventsControllerIntegrationTest(
    @Autowired
    val restTemplate: TestRestTemplate,
    @Autowired
    val embeddedKafkaBroker: EmbeddedKafkaBroker
) {

    lateinit var consumer: Consumer<Int, String>

    @BeforeEach
    fun setup() {
        val consumerProperties =
            HashMap<String, Any>(KafkaTestUtils.consumerProps("group1", "true", embeddedKafkaBroker).toMap())
        consumer = DefaultKafkaConsumerFactory(
            consumerProperties,
            IntegerDeserializer(),
            StringDeserializer()
        ).createConsumer()
        embeddedKafkaBroker.consumeFromAllEmbeddedTopics(consumer)
    }

    @AfterEach
    fun teardown() {
        consumer.close()
    }

    @Test
    fun postLibraryEvent() {
        // given
        val book = Book(bookId = 123, bookAuthor = "Vitor", bookName = "Kafka using spring boot")
        val libraryEvent = LibraryEvent(libraryEventId = 1, book = book, libraryEventType = LibraryEventType.NEW)

        val headers = HttpHeaders()
        headers.set("content-type", MediaType.APPLICATION_JSON.toString())
        val request = HttpEntity<LibraryEvent>(libraryEvent, headers)

        // when
        val response: ResponseEntity<LibraryEvent> =
            restTemplate.exchange(url = "/rest/v1/events", method = HttpMethod.POST, request, LibraryEvent::class.java)

        // then
        assertEquals(HttpStatus.CREATED, response.statusCode)

        val consumerRecord = KafkaTestUtils.getSingleRecord(consumer, "library-events")
        val value = consumerRecord.value()
        val expected = "{\"libraryEventId\":1,\"book\":{\"bookId\":123,\"bookName\":\"Kafka using spring boot\",\"bookAuthor\":\"Vitor\"},\"libraryEventType\":\"NEW\"}"
        assertEquals(expected, value)
    }
}