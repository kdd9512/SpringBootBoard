package com.springbootboard.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@Repository
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;
    private String title;
    private String content;
    private String writerEmail; // 작성자 email
    private String writerName; // 작성자 이름
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int replyCount; // 게시글의 reply 수;

}
