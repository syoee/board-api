package com.board.api.dto.board.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    @Setter
    private Long id;
    private String title;
    private String content;
}
