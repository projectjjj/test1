package com.example.test1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

    public Memo getMemos(Long id){
        return memoRepository.findById(id).get();
    }

    public Memo postMemo(MemoDto memoDto){
        Memo memo = new Memo(memoDto);
        memoRepository.save(memo);
        return memo;
    }

    public Reply postReply(ReplyDto replyDto) {
        Reply reply = new Reply(replyDto);
        replyRepository.save(reply);
        return reply;
    }

}
