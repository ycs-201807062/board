package com.example.board.VO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class BoardDetailDto {
    private int board_no;
    private String board_title;
    private String board_contents;
    private String memberName;

    private List<ReplyDetailDto> replys;
}
