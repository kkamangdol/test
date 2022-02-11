package com.sparta.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String content;

    public Memo(String user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }

    public Memo(MemoRequestDto requestDto) {
        this.user_id = requestDto.getUser_id();
        this.content = requestDto.getContent();
    }

    public void update(MemoRequestDto requestDto) {
        this.user_id = requestDto.getUser_id();
        this.content = requestDto.getContent();
    }
}
