package com.example.test1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String tag;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "memoId", nullable = false)
    private Memo memo;

    public Tag(MemoDto memoDto, Memo memo) {
        this.tag = memoDto.getTag();
        this.memo = memo;
    }

}
