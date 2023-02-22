package com.example.board.Controller;

import com.example.board.Service.BoardService;
import com.example.board.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/board/*"})
public class BoardController {
    @Autowired
    private BoardService boardService;

    public BoardController() {
    }

    @GetMapping({"/list"})
    public String boardListGET(Model model) {
        List<BoardVO> voList = this.boardService.select();
        model.addAttribute("list", voList);
        return "list";
    }

    @GetMapping({"/enroll"})
    public String boardEnrollGET() {
        return "enroll";
    }

    @PostMapping({"/enroll"})
    public String boardEnrollGET(BoardVO boardVO) {
        this.boardService.enroll(boardVO);
        return "/list";
    }
}
