package com.springbootboard.service;

import com.springbootboard.dto.BoardDTO;
import com.springbootboard.dto.PageRequestDTO;
import com.springbootboard.dto.PageResultDTO;
import com.springbootboard.entity.Board;
import com.springbootboard.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto); // 작성
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO); // 목록 처리
    BoardDTO get(Long bno); // 조회
    void removeWithReplies(Long bno); // 삭제

    default Board dtoToEntity(BoardDTO dto){

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }

    default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue()) // Long 값을 int 로 변환처리.
                .build();

        return boardDTO;
    }
}
