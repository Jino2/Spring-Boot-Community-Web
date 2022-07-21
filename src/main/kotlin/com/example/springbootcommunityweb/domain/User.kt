package com.example.springbootcommunityweb.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user_table") // Couldn't add "user"table, "user" is keyword
data class User(
   @Column
    val name: String,

    @Column
    val password: String,

    @Column
    val email: String,

    @Column
    val createdDate: LocalDateTime,

    @Column
    val updatedDate: LocalDateTime? = null
) {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long = 0L
}