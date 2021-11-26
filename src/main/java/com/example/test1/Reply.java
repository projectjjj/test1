package com.example.test1;

import com.example.test1.Memo;
import com.example.test1.ReplyDto;
import com.example.test1.Timestamped;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Reply extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String reply;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "memoId", nullable = false)
    private Memo memo;

    public Reply(ReplyDto replyDto, Memo memo) {
        this.reply = replyDto.getReply();
        this.memo = memo;
    }
}
