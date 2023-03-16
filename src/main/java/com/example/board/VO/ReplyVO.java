package com.example.board.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {
    private int reply_no;
    private int board_no;
    private String reply_contents;
    private String memberName;
}
