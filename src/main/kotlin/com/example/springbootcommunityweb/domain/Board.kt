package com.example.springbootcommunityweb.domain


import com.example.springbootcommunityweb.domain.enums.BoardType
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table
class Board(

    @Column
    val title: String,

    @Column
    val subTitle: String,

    @Column
    val content: String,

    @Column
    @Enumerated(EnumType.STRING)
    val boardType: BoardType,

    @OneToOne(fetch = FetchType.LAZY)
    val user: User,

    @Column
    val createdDate: LocalDateTime,

    @Column
    val updatedDate: LocalDateTime? = null
) : Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long = 0
}
