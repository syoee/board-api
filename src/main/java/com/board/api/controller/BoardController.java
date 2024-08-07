package com.board.api.controller;

import com.board.api.dto.board.request.BoardCreateRequestDto;
import com.board.api.dto.board.request.BoardUpdateRequestDto;
import com.board.api.dto.board.response.BoardCreateResponseDto;
import com.board.api.dto.board.response.BoardReadResponseDto;
import com.board.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/boards")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public BoardCreateResponseDto createBoard(
            @RequestBody BoardCreateRequestDto boardCreateRequestDto) {
        return boardService.saveBoard(boardCreateRequestDto);
    }

    @GetMapping
    public List<BoardReadResponseDto> getBoardList() {
        return boardService.getAllBoardList();
    }

    @GetMapping("/{boardId}")
    public BoardReadResponseDto getBoard(@PathVariable("boardId") Long boardId) {
        return boardService.getBoardById(boardId);
    }

    @PutMapping("/{boardId}")
    public void updateBoard(@PathVariable("boardId") Long boardId,
                            @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        boardUpdateRequestDto.setId(boardId);

        boardService.updateBoard(boardUpdateRequestDto);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
