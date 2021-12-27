package com.springbootboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer") // @ToString 은 항상 exclude
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne // DB 상에서 Foreign Key 관계로 연결된 Entity 클래스에 설정한다.
    private Member writer; // 연관관계 지정.
}
