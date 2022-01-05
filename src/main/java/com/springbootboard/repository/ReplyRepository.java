package com.springbootboard.repository;

import com.springbootboard.entity.Board;
import com.springbootboard.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 연관된 Entity 와 Primary key 로 이용된 값의 자료형을 제네릭.
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // Board 삭제 시 댓글 삭제.
    @Modifying
    @Query("delete from Reply r where r.board.bno =:bno")
    void deleteByBno(Long bno);

    // 게시물로 댓글 목록 가져오기.
    List<Reply> getRepliesByBoardOrderByRno(Board board);

}
