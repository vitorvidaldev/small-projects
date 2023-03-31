package dev.vitorvidal.udemykafkaproducer.udemykafka.controller

import dev.vitorvidal.udemykafkaproducer.udemykafka.component.LibraryEventProducer
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEvent
import dev.vitorvidal.udemykafkaproducer.udemykafka.domain.LibraryEventType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/events")
class LibraryEventsController(val libraryEventProducer: LibraryEventProducer) {

    @PostMapping
    fun postLibraryEvent(@RequestBody libraryEvent: LibraryEvent): ResponseEntity<LibraryEvent> {
        libraryEvent.libraryEventType = LibraryEventType.NEW
        libraryEventProducer.sendLibraryEvent(libraryEvent)
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent)
    }
}