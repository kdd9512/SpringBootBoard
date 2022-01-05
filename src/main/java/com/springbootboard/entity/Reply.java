package com.springbootboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replier;

    @ManyToOne(fetch = FetchType.LAZY) // DB 상에서 Foreign Key 관계로 연결된 Entity 클래스에 설정한다.
    private Board board; // 연관관계 지정.
}
