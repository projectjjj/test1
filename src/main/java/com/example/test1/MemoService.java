package com.example.test1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;
    private final ReplyRepository replyRepository;

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
    @Transactional
    public Reply postReply(ReplyDto replyDto) { //반환값 Reply에서 void로 수정
        Memo memo = memoRepository.findById(replyDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 게시글이 없습니다")
        );
        Reply reply = new Reply(replyDto,memo);
        return replyRepository.save(reply);
    }

}
