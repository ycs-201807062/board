package com.example.board.Mapper;

import com.example.board.VO.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<ReplyVO> replySelect(int board_no);
    ReplyVO replySelectNo(int reply_no);
    int replyInsert(ReplyVO replyVO);
    void replymodify(ReplyVO replyVO);

    void replydelete(int reply_no);
    void Alldelete(int board_no);
}
