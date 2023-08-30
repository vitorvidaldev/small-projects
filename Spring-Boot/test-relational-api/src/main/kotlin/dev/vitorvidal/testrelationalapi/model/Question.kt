package dev.vitorvidal.testrelationalapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "question")
data class Question(
    @Id @Column(name = "question_id") val questionId: UUID,
    @Column(name = "title") val title: String,
    @Column(name = "description") val description: String,
    @Column(name = "options") val options: MutableList<String>,
    @Column(name = "correct_answer") val correctAnswer: String
)