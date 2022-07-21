package com.example.springbootcommunityweb.repository

import com.example.springbootcommunityweb.domain.Board
import com.example.springbootcommunityweb.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long> {
    fun findByUser(user:User): Board
}