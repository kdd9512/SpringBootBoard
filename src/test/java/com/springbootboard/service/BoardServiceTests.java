package com.springbootboard.service;

import com.springbootboard.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        // 현재 DB 상에 존재하는 email 이어야 한다.
        BoardDTO dto = BoardDTO.builder()
                .title("Test")
                .content("Test Content...")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);

    }
}
