package com.example.test1;

import lombok.Getter;
import lombok.Setter;

@Setter //튜터님 코드 비교후 추가
@Getter
public class ReplyDto {
    private Long idx;
    private String reply;
}
