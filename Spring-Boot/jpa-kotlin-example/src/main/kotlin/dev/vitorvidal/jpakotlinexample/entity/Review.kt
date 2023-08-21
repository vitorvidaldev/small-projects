package dev.vitorvidal.jpakotlinexample.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Review {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var rating: String? = null

    @Column
    var description: String? = null

    @UpdateTimestamp
    val lastUpdatedDate: LocalDateTime? = null

    @CreationTimestamp
    val createdDate: LocalDateTime? = null

    protected constructor()
    constructor(description: String?) {
        this.description = description
    }

    override fun toString(): String {
        return "Review{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}'
    }
}
