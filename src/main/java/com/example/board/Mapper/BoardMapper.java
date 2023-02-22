package com.example.board.Mapper;

import com.example.board.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void enroll(BoardVO boardVO);

    List<BoardVO> select();
}
