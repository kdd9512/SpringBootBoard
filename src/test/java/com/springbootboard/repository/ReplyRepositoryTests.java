package com.springbootboard.repository;

import com.springbootboard.entity.Board;
import com.springbootboard.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

//    @Test
//    public void insertReply() {
//
//        // rangeClosed(시작번호, 입력할 개수)
//        IntStream.rangeClosed(1, 300).forEach(i -> {
//
//            long bno = (long) (Math.random() * 100) + 1; // 1 부터 100 까지의 임의 번호
//
//            Board board = Board.builder().bno(bno).build();
//
//            Reply reply = Reply.builder()
//                    .text("Reply " + i)
//                    .board(board)
//                    .replier("guest")
//                    .build();
//
//            replyRepository.save(reply);
//
//        });
//    }

    @Test
    public void readReply() {

        Optional<Reply> result = replyRepository.findById(1L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());

    }

    @Test
    public void testListByBoard() {

        List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(
                Board.builder().bno(97L).build());

        replyList.forEach(System.out::println);

    }


}
