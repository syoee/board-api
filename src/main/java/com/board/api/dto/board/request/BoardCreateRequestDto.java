package com.board.api.dto.board.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {
    private String title;
    private String content;
}
