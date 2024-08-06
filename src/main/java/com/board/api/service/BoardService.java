package com.board.api.service;

import com.board.api.dto.board.request.BoardCreateRequestDto;
import com.board.api.dto.board.request.BoardUpdateRequestDto;
import com.board.api.dto.board.response.BoardCreateResponseDto;
import com.board.api.dto.board.response.BoardReadResponseDto;

import java.util.List;

public interface BoardService {
    BoardCreateResponseDto saveBoard(BoardCreateRequestDto boardCreateRequestDto);

    List<BoardReadResponseDto> getAllBoardList();

    BoardReadResponseDto getBoardById(Long id);

    void updateBoard(BoardUpdateRequestDto boardUpdateRequestDto);

    void deleteBoard(Long id);

}
