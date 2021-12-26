package com.springbootboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity{

    @Id // 이는 회원마다 다른 고유값이므로 primary key 로 사용할 값이 된다.
    private String email;

    private String password;

    private String name;
}
