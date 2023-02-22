package com.example.board.Service;

import com.example.board.Mapper.ReplyMapper;
import com.example.board.VO.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImp implements ReplyService {
    @Autowired
    ReplyMapper mapper;

    @Override
    public List<ReplyVO> replySelect(int board_no) {
        return mapper.replySelect(board_no);
    }

    @Override
    public ReplyVO replySelectNo(int reply_no) {
        return mapper.replySelectNo(reply_no);
    }

    @Override
    public int replyInsert(ReplyVO replyVO) {

    int result = mapper.replyInsert(replyVO);
    return result;
    }

    @Override
    public void replymodify(ReplyVO replyVO) {
        mapper.replymodify(replyVO);
    }

    @Override
    public void replydelete(int reply_no) {
        mapper.replydelete(reply_no);
    }

    @Override
    public void Alldelete(int board_no) {
        mapper.Alldelete(board_no);
    }

}
