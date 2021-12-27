package com.springbootboard.repository;

import com.springbootboard.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

// 연관된 Entity 와 Primary key 로 이용된 값의 자료형을 제네릭.
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
