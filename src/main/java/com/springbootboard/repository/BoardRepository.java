package com.springbootboard.repository;

import com.springbootboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 연관된 Entity 와 Primary key 로 이용된 값의 자료형을 제네릭.
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 한 개의 row (Object) 내에 Object[] 로 나옴.
    @Query("select b,w from Board b left join b.writer w where b.bno = :bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    @Query("select b,r from Board b left join Reply r on r.board = b where b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query(value = "select b,w, count(r) from Board b " +
            "left join b.writer w " +
            "left join Reply r on r.board = b group by b",
            countQuery = "select count(b) from Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable); // 목록 화면에 필요한 데이터

}
