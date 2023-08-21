package dev.vitorvidal.jpakotlinexample.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "course")
@NamedQuery(name = "query_get_all_courses", query = "Select c From Course c")
class Course {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @UpdateTimestamp
    val lastUpdatedDate: LocalDateTime? = null

    @CreationTimestamp
    val createdDate: LocalDateTime? = null

    protected constructor()
    constructor(name: String?) {
        this.name = name
    }

    override fun toString(): String {
        return "Course{id=$id, name='$name'}"
    }
}