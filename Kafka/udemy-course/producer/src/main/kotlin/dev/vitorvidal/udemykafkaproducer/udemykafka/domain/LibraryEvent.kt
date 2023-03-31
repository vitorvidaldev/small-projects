package dev.vitorvidal.udemykafkaproducer.udemykafka.domain

data class LibraryEvent(val libraryEventId: Int, val book: Book, var libraryEventType: LibraryEventType?)