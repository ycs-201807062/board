package com.example.board.Service;

import com.example.board.VO.ReplyVO;

import java.util.List;

public interface ReplyService {
    List<ReplyVO> replySelect(int board_no);
    ReplyVO replySelectNo(int reply_no);
    int replyInsert(ReplyVO replyVO);

    void replymodify(ReplyVO replyVO);

    void replydelete(int reply_no);
    void Alldelete(int board_no);
}
