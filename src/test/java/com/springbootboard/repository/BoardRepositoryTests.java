package com.springbootboard.repository;

import com.springbootboard.entity.Board;
import com.springbootboard.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

//    @Test
//    public void insertBoard() {
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//
//            Member member = Member.builder()
//                    .email("user" + i + "@aaa.com")
//                    .build();
//
//            Board board = Board.builder()
//                    .title("Title..." + i)
//                    .content("Content " + i)
//                    .writer(member)
//                    .build();
//
//            boardRepository.save(board);
//        });
//    }
    @Transactional // 해당 메서드를 하나의 트랜잭션으로 설정한다. 필요할 때 DB 에 재연결 되어 자료를 가져올 수 있게끔 한다.
    @Test
    public void testRead1(){

        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }
}
