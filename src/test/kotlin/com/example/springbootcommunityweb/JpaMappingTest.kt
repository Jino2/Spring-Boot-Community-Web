package com.example.springbootcommunityweb

import com.example.springbootcommunityweb.domain.Board
import com.example.springbootcommunityweb.domain.User
import com.example.springbootcommunityweb.domain.enums.BoardType
import com.example.springbootcommunityweb.repository.BoardRepository
import com.example.springbootcommunityweb.repository.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime

@DataJpaTest
class JpaMappingTest @Autowired constructor(
    val userRepository: UserRepository,
    val boardRepository: BoardRepository
) {
    private val boardTestTitle = "테스트"
    private val email = "test@gmail.com"

    @BeforeEach
    fun init() {
        val user = userRepository.save(
            User(
                name = "havi",
                password = "test",
                email = email,
                createdDate = LocalDateTime.now()
            )
        )
        boardRepository.save(
            Board(
                title = boardTestTitle,
                subTitle = "sub Title",
                content = "content",
                boardType = BoardType.Free,
                createdDate = LocalDateTime.now(),
                updatedDate = LocalDateTime.now(),
                user = user
            )
        )
    }

   @Test
   @DisplayName("제대로 생성됐는지 테스트")
   fun instanceGeneratedCorrectly() {
       val user = userRepository.findByEmail(email)
       user.apply {
           Assertions.assertThat(name).isEqualTo("havi")
           Assertions.assertThat(password).isEqualTo("test")
           Assertions.assertThat(email).isEqualTo(email)
       }

       boardRepository.findByUser(user).apply {
           Assertions.assertThat(title).isEqualTo(boardTestTitle)
           Assertions.assertThat(subTitle).isEqualTo("sub Title")
           Assertions.assertThat(content).isEqualTo("content")
           Assertions.assertThat(boardType).isEqualTo(BoardType.Free)
       }
   }
}