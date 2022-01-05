package com.springbootboard.service;

import com.springbootboard.dto.ReplyDTO;
import com.springbootboard.entity.Board;
import com.springbootboard.entity.Reply;

import java.util.List;

public interface ReplyService {

    Long register(ReplyDTO replyDTO); // 댓글 등록

    List<ReplyDTO> getList(Long bno); // 특정 게시물의 댓글 목록

    void modify(ReplyDTO replyDTO); // 댓글 수정

    void remove(Long rno); // 댓글 삭제

    // Reply 객체를 ReplyDTO 로 변환.
    // Board 객체의 처리가 수반된다.
    default Reply dtoToEntity(ReplyDTO replyDTO) {

        Board board = Board.builder().bno(replyDTO.getBno()).build();

        return Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replier(replyDTO.getReplier())
                .board(board)
                .build();
    }

    // Reply 객체를 ReplyDTO 로 변환.
    // Board 객체가 필요 없으므로 게시물 번호만 취한다.
    default ReplyDTO entityToDTO(Reply reply){

        return ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replier(reply.getReplier())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();
    }
}
