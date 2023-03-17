package com.example.board.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class getVO {
    private int board_no;
    private String board_title;
    private String board_contents;
    private String memberName;

    private int reply_no;
    private String reply_contents;

    private String reply_member;
}
