package com.springbootboard.service;

import com.springbootboard.dto.ReplyDTO;
import com.springbootboard.entity.Board;
import com.springbootboard.entity.Reply;
import com.springbootboard.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO replyDTO) {

        Reply reply = dtoToEntity(replyDTO);

        replyRepository.save(reply);

        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {

        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(
                Board.builder().bno(bno).build());

        return result.stream().map(reply ->
            entityToDTO(reply)).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);

        replyRepository.save(reply);
    }

    @Override
    public void remove(Long rno) {

        replyRepository.deleteByBno(rno);
    }

    @Override
    public Reply dtoToEntity(ReplyDTO replyDTO) {
        return ReplyService.super.dtoToEntity(replyDTO);
    }

    @Override
    public ReplyDTO entityToDTO(Reply reply) {
        return ReplyService.super.entityToDTO(reply);
    }
}