package com.example.test1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Reply extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String reply;

    @ManyToOne
    @JoinColumn(name = "memo", nullable = false)
    private Memo memo;

    public Reply(ReplyDto replyDto){
        this.reply = replyDto.getReply();
    }
}
