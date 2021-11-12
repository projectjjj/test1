package com.example.test1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository repository;

    @PostMapping("/api/post")
    public Memo postMemo(@RequestBody MemoDto memoDto) {
        Memo memo = new Memo(memoDto);
        return repository.save(memo);
    }

    @GetMapping("/api/post")
    public List<Memo> getMemos() {
        return repository.findAll();
    }
}
