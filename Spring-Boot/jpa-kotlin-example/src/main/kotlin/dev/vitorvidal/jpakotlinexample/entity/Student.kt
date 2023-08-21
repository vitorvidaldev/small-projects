package dev.vitorvidal.jpakotlinexample.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Student(
    @Id @GeneratedValue var id: Long? = null,

    @Column(nullable = false) var name: String? = null,

    @OneToOne(fetch = FetchType.LAZY) var passport: Passport? = null,

    @UpdateTimestamp val lastUpdatedDate: LocalDateTime? = null,

    @CreationTimestamp val createdDate: LocalDateTime? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        other as Student

        return id != null && id == other.id
    }

    override fun hashCode(): Int =
        this.id?.hashCode() ?: 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
