package com.board.api.service.impl;

import com.board.api.dto.board.request.BoardCreateRequestDto;
import com.board.api.dto.board.request.BoardUpdateRequestDto;
import com.board.api.dto.board.response.BoardCreateResponseDto;
import com.board.api.dto.board.response.BoardReadResponseDto;
import com.board.api.entity.Board;
import com.board.api.repository.BoardRepository;
import com.board.api.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardCreateResponseDto saveBoard(BoardCreateRequestDto boardCreateRequestDto) {
        if (Objects.isNull(boardCreateRequestDto.getTitle())) {
            throw new IllegalArgumentException("제목이 없습니다.");
        }

        if (Objects.isNull(boardCreateRequestDto.getContent())) {
            throw new IllegalArgumentException("내용이 없습니다.");
        }

        Board board = boardRepository.save(Board.builder()
                .title(boardCreateRequestDto.getTitle())
                .content(boardCreateRequestDto.getContent())
                .build());

        return BoardCreateResponseDto.builder()
                .id(board.getId())
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<BoardReadResponseDto> getAllBoardList() {

        List<Board> boardList = boardRepository.findAll();

        return boardList.stream()
                .map(dto -> BoardReadResponseDto.builder()
                        .id(dto.getId())
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public BoardReadResponseDto getBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글 입니다."));

        return BoardReadResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

    @Transactional
    @Override
    public void updateBoard(BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(boardUpdateRequestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글 입니다."));

        if (Objects.nonNull(boardUpdateRequestDto.getTitle()) && !board.getTitle().equals(boardUpdateRequestDto.getTitle())) {
            board.setTitle(boardUpdateRequestDto.getTitle());
        }

        if (Objects.nonNull(boardUpdateRequestDto.getContent()) && !board.getContent().equals(boardUpdateRequestDto.getContent())) {
            board.setTitle(boardUpdateRequestDto.getContent());
        }

        boardRepository.save(board);
    }

    @Transactional
    @Override
    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글 입니다."));

        boardRepository.delete(board);
    }
}
