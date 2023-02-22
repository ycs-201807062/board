package com.example.board.Service;

import com.example.board.Mapper.BoardMapper;
import com.example.board.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImp implements BoardService{
    @Autowired
    private BoardMapper mapper;
    @Override
    public void enroll(BoardVO boardVO) {
        this.mapper.enroll(boardVO);
    }

    public List<BoardVO> select() {
        List<BoardVO> voList = this.mapper.select();
        return voList;
    }
}
