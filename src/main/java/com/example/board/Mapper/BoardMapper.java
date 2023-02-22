package com.example.board.Mapper;

import com.example.board.VO.BoardVO;
import com.example.board.VO.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void enroll(BoardVO boardVO);

    List<BoardVO> select();

    BoardVO get(int board_no);
    void modify(BoardVO boardVO);

    void delete(int board_no);
    List<BoardVO> getListPaging(Criteria cri);

    int getTotal();
}
