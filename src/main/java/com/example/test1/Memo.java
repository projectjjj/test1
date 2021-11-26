package com.example.test1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //튜터님 코드와 비교후 추가
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "memo")
    private List<Reply> replyList;

    @OneToMany(mappedBy = "memo")
    private List<Tag> tagList;

    //생성자
    public Memo(MemoDto memoDto){
        this.title = memoDto.getTitle();
        this.content = memoDto.getContent();
    }
}