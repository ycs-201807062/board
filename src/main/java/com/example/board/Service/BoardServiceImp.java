package com.example.board.Service;

import com.example.board.Mapper.BoardMapper;
import com.example.board.VO.BoardVO;
import com.example.board.VO.Criteria;
import com.example.board.VO.getVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImp implements BoardService{

    private final BoardMapper mapper;

    public BoardServiceImp(BoardMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void enroll(BoardVO boardVO) {
        this.mapper.enroll(boardVO);
    }

    public List<BoardVO> select() {
        List<BoardVO> voList = this.mapper.select();
        return voList;
    }

    @Override
    public List<getVO> get(int board_no) {
        return mapper.get(board_no);
    }

    @Override
    public void modify(BoardVO boardVO) {
        this.mapper.modify(boardVO);
    }

    @Override
    public void delete(int board_no) {
        this.mapper.delete(board_no);
    }

    @Override
    public List<BoardVO> getListPaging(Criteria cri) {
        return mapper.getListPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
        return mapper.getTotal(cri);
    }

}
