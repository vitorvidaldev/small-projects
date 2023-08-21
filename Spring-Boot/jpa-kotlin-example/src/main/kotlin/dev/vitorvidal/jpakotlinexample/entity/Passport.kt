package dev.vitorvidal.jpakotlinexample.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Passport(
    @Id @GeneratedValue var id: Long? = null,
    @Column(nullable = false) var number: String? = null,
    @UpdateTimestamp val lastUpdatedDate: LocalDateTime? = null,
    @CreationTimestamp val createdDate: LocalDateTime? = null,
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") var student: Student? = null
)