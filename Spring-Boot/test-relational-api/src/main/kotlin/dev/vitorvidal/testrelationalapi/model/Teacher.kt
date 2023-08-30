package dev.vitorvidal.testrelationalapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "teacher")
data class Teacher(
    @Id @Column(name = "email") val email: String,
    @Column(name = "name") val name: String,
)