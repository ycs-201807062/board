package com.example.board.Service;

import com.example.board.VO.BoardVO;
import com.example.board.VO.Criteria;
import com.example.board.VO.getVO;
import java.util.List;



public interface BoardService {
    void enroll(BoardVO boardVO);

    List<BoardVO> select();

   List<getVO> get(int board_no);
    void modify(BoardVO boardVO);
    void delete(int board_no);
    List<BoardVO> getListPaging(Criteria cri);
    int getTotal(Criteria cri);

}