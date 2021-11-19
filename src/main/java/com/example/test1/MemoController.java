package com.example.test1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository repository;
    private final MemoService memoService;

    @PostMapping("/api/post")
    public Memo postMemo(@RequestBody MemoDto memoDto) {
        Memo memo = new Memo(memoDto);
        return repository.save(memo);
    }

    @GetMapping("/api/post")
    public List<Memo> getMemos() {
        return repository.findAll();
    }

    @GetMapping("/api/post/{id}")
    public Memo getPost(@PathVariable Long id){
        return memoService.getMemos(id);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long modifyMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return id;
    }
}
