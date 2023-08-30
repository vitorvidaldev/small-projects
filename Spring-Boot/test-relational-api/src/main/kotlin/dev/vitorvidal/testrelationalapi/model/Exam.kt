package dev.vitorvidal.testrelationalapi.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "exam")
data class Exam(
    @Id @Column(name = "exam_id") val examId: UUID,
    @Column(name = "name") val name: String,
    @Column(name = "description") val description: String,
    @OneToMany val questions: MutableList<Question>
)