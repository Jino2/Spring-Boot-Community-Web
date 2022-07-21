package com.example.springbootcommunityweb

import com.example.springbootcommunityweb.domain.Board
import com.example.springbootcommunityweb.domain.User
import com.example.springbootcommunityweb.domain.enums.BoardType
import com.example.springbootcommunityweb.repository.BoardRepository
import com.example.springbootcommunityweb.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.stream.IntStream

@SpringBootApplication
class SpringBootCommunityWebApplication {

    @Bean
    fun runner(
        userRepository: UserRepository,
        boardRepository: BoardRepository
    ): CommandLineRunner {
        return CommandLineRunner {
            val user = userRepository.save(
                User(
                    name = "havi",
                    password = "test",
                    email = "havi@gmail.com",
                    createdDate = LocalDateTime.now()
                )
            )

            IntStream.rangeClosed(1, 200)
                .forEach { index ->
                    boardRepository.save(
                        Board(
                            title = "게시글${index}",
                            subTitle = "순서${index}",
                            content = "contents",
                            boardType = BoardType.Free,
                            createdDate = LocalDateTime.now(),
                            updatedDate = LocalDateTime.now(),
                            user = user
                        )
                    )
                }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootCommunityWebApplication>(*args)
}
