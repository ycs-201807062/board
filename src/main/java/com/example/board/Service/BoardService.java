package com.example.board.Service;

import com.example.board.VO.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {
    void enroll(BoardVO boardVO);

    List<BoardVO> select();
}