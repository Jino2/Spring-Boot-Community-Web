package com.example.springbootcommunityweb.repository

import com.example.springbootcommunityweb.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User
}