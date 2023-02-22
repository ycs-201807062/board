package com.example.board.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
    private int board_no;
    private String board_title;
    private String board_contents;
    private String board_user;
}
