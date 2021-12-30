package com.springbootboard.service;

import com.springbootboard.dto.BoardDTO;
import com.springbootboard.dto.PageRequestDTO;
import com.springbootboard.dto.PageResultDTO;
import com.springbootboard.entity.Board;
import com.springbootboard.entity.Member;
import com.springbootboard.repository.BoardRepository;
import com.springbootboard.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository; // 자동주입 final
    private final ReplyRepository replyRepository; // 댓글 참조를 위한 repository;

    @Override
    public Long register(BoardDTO dto) {
        log.info(dto);
        Board board = dtoToEntity(dto);
        repository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = (en ->
                entityToDTO((Board) en[0], (Member) en[1], (Long) en[2])
        );

        Page<Object[]> result = repository.getBoardWithReplyCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending())
        );

        return new PageResultDTO<>(result, fn);

    }

    @Override
    public BoardDTO get(Long bno) {
        Object result = repository.getBoardByBno(bno);
        Object[] arr = (Object[]) result;

        return entityToDTO((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }

    @Transactional // 1. 게시물 삭제. 2.게시물 내의 댓글 삭제 라는 작업을 하나의 transaction 으로 처리하기 위함.
    @Override
    public void removeWithReplies(Long bno) {
        // 댓글 삭제
        replyRepository.deleteByBno(bno);
        // 게시글 삭제
        repository.deleteById(bno);
    }

    @Transactional // LazyInitialization 에러 방지를 위한 annotation. 지연조회 시점까지 세션을 유지시킨다.
    @Override
    public void modify(BoardDTO boardDTO) {

        // getOne 은 deprecated 되었음. 때문에 지연조회까지 세션유지를 위한 @Transactional annotation 이 추가로 필요하다.
        Board board = repository.getById(boardDTO.getBno());

        if (board != null) {
            board.changeTitle(boardDTO.getTitle());
            board.changeContent(boardDTO.getContent());

            repository.save(board);
        }

    }
}
