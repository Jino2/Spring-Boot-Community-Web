package com.example.springbootcommunityweb.service

import com.example.springbootcommunityweb.domain.Board
import com.example.springbootcommunityweb.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BoardService @Autowired constructor(
    private val boardRepository: BoardRepository
) {

    fun findBoardList(pageable: Pageable): Page<Board> {
        PageRequest.of(
            if (pageable.pageNumber <= 0) 0 else pageable.pageNumber - 1,
            pageable.pageSize
        )
        return boardRepository.findAll(pageable)
    }

    fun findBoardByIdx(idx: Long): Board {
        return boardRepository
            .findById(idx)
            .orElseThrow()
    }
}