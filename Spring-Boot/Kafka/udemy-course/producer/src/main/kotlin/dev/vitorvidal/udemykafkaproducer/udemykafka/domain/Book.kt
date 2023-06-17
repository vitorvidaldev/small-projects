package dev.vitorvidal.udemykafkaproducer.udemykafka.domain

import lombok.Builder

@Builder
data class Book(val bookId: Int, val bookName: String, val bookAuthor: String)
