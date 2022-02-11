package com.sparta.test.controller;

import com.sparta.test.domain.Memo;
import com.sparta.test.domain.MemoRepository;
import com.sparta.test.domain.MemoRequestDto;
import com.sparta.test.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //쓰기
    @PostMapping("/api/post_write")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    //불러오기
    @GetMapping("/api/post_TIL")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    //수정
    @PostMapping("/api/post_custom/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }
    //삭제
    @DeleteMapping("/api/post_delete/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

}