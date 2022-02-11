package com.sparta.test.domain;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String title;
    private String content;
    private String user_id;
    private String post_id;
}
