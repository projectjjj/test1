package com.example.test1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

    public Memo getMemos(Long id){
        return memoRepository.findById(id).get();
    }


}
