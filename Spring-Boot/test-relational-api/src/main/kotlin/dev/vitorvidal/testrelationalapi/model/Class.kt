package dev.vitorvidal.testrelationalapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "class")
data class Class(
    @Id @Column(name = "class_identifier") val classIdentifier: UUID,
    @Column(name = "subject") val subject: String,
    @Column(name = "name") val name: String,
    @Column(name = "description") val description: String
)