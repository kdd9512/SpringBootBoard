package com.springbootboard.repository.search;

import com.springbootboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {

    Board search1();

    // 완전히 같은 변수를 갖는 PageRequestDTO 를 parameter 로 이용해도 될 것 같지만,
    // DTO 는 가능하면 repository 영역에서는 다루지 않는게 좋다
    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
