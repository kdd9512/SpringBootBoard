package com.springbootboard.controller;

import com.springbootboard.dto.ReplyDTO;
import com.springbootboard.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService; // 자동 주입을 위해 final 선언

    // value 에 {} 로 일부를 묶은 변수를 사용. 메서드 내에서 @PathVariable 로 이 감싼 부분을 뭘로 할지를 결정.
    // produces 는 지정한 dataType 으로만 사용자에게 응답하겠다는 의미.
    @GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno) {

        log.info("bno : " + bno);

        return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);

    }
}
