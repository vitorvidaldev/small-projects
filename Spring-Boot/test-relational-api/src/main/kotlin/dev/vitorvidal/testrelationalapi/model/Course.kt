package dev.vitorvidal.testrelationalapi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "course")
data class Course(
    @Id @Column(name = "identifier") val id: String,
    @Column(name = "name") val courseName: String,
    @ManyToOne(fetch = FetchType.LAZY) val teacher: Teacher,
    @OneToMany(fetch = FetchType.LAZY) val classes: MutableList<Class>,
    @OneToMany(fetch = FetchType.LAZY) val exams: MutableList<Exam>,
    @Column(name = "creation_timestamp") val creationTimestamp: LocalDateTime
)