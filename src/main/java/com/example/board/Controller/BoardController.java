package com.example.board.Controller;

import com.example.board.Service.BoardService;
import com.example.board.Service.ReplyService;
import com.example.board.VO.BoardVO;
import com.example.board.VO.Criteria;
import com.example.board.VO.PageMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping({"/board/*"})
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;
    public BoardController() {
    }

    @GetMapping({"/list"})
    public String boardListGET(Model model, Criteria cri) {

        model.addAttribute("list", boardService.getListPaging(cri));
        int total = boardService.getTotal(cri);
        PageMaker pageMaker = new PageMaker(cri,total);
        model.addAttribute("pageMaker",pageMaker);
        return "list";
    }

    @GetMapping({"/enroll"})
    public String boardEnrollGET() {
        return "enroll";
    }

    @PostMapping({"/enroll"})
    public String boardEnrollPOST(BoardVO boardVO,RedirectAttributes rttr) {
        this.boardService.enroll(boardVO);
        rttr.addFlashAttribute("result","enroll success");
        return "redirect:list";
    }

    /* 게시판 조회 */
    @GetMapping("/get")
    public String boardGetPageGET(@RequestParam(name = "board_no") int id, Model model) {
        model.addAttribute("pageInfo", boardService.get(id));
        model.addAttribute("reply",replyService.replySelect(id));

        return "get";
    }


    @GetMapping("/modify")
    public String boardModifyGET(@RequestParam(name = "board_no") int id, Model model) {
        model.addAttribute("pageInfo", boardService.get(id));
        return "modify";
    }
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board,RedirectAttributes rttr) {
        rttr.addFlashAttribute("result","modify success");
        this.boardService.modify(board);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String boardDeleteGET(@RequestParam(name = "board_no")int board_no,RedirectAttributes rttr){
        rttr.addFlashAttribute("result","delete success");
        this.replyService.Alldelete(board_no);
        this.boardService.delete(board_no);
        return "redirect:list";
    }

}
