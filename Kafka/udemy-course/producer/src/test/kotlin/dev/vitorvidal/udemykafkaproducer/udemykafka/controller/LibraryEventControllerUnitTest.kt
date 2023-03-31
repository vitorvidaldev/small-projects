package dev.vitorvidal.udemykafkaproducer.udemykafka.controller

import com.fasterxml.jackson.databind.ObjectMapper
import dev.vitorvidal.udemykafkaproducer.udemykafka.component.LibraryEventProducer
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.Book
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEvent
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEventType
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doNothing
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(LibraryEventsController::class)
@AutoConfigureMockMvc
class LibraryEventControllerUnitTest {
    private val objectMapper: ObjectMapper = ObjectMapper()

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var libraryEventProducer: LibraryEventProducer

    @Test
    fun postLibraryEvent() {
        val book = Book(bookId = 123, bookAuthor = "Vitor", bookName = "Kafka using spring boot")
        val libraryEvent = LibraryEvent(libraryEventId = 1, book = book, libraryEventType = LibraryEventType.NEW)
        val json = objectMapper.writeValueAsString(libraryEvent)

        doNothing().`when`(libraryEventProducer).sendLibraryEvent(any())
        mockMvc.perform(post("/rest/v1/events").content(json).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated)
    }

}
