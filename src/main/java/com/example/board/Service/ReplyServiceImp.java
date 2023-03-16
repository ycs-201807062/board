package com.example.board.Service;

import com.example.board.Mapper.ReplyMapper;
import com.example.board.VO.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImp implements ReplyService {
    private final ReplyMapper mapper;

    public ReplyServiceImp(ReplyMapper mapper) {
        this.mapper = mapper;
    }

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
        mapper.replyModify(replyVO);
    }

    @Override
    public void replydelete(int reply_no) {
        mapper.replyDelete(reply_no);
    }

    @Override
    public void Alldelete(int board_no) {
        mapper.AllDelete(board_no);
    }

}
