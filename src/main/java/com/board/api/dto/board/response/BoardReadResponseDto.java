package com.board.api.dto.board.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardReadResponseDto {
    private Long id;
    private String title;
    private String content;
}
