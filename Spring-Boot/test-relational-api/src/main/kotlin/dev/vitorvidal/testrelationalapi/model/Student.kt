package dev.vitorvidal.testrelationalapi.model

import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy
import org.hibernate.proxy.LazyInitializer
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "student")
data class Student(
    @Id @Column(name = "email") val email: String,
    @Column(name = "name") val name: String,
    @Column(name = "age") val age: Int,
    @Column(name = "birth_date") val birthDate: LocalDate,
    @ManyToMany(fetch = FetchType.LAZY) val courses: MutableList<Course>, // TODO validate how many to many works
    @Column(name = "registration_timestamp") val registrationTime: LocalDateTime
) : HibernateProxy { // TODO verify how Hibernate Proxy works and why JPA Buddy uses it
    @Override
    override fun toString(): String {
        return this::class.simpleName + "(email = $email )"
    }

    override fun writeReplace(): Any {
        TODO("Not yet implemented")
    }

    override fun getHibernateLazyInitializer(): LazyInitializer {
        TODO("Not yet implemented")
    }

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as Student

        return email != null && email == other.email
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}