package com.example.board.Controller;

import com.example.board.Service.ReplyService;
import com.example.board.VO.BoardVO;
import com.example.board.VO.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

    @Autowired
    ReplyService replyService;
    @PostMapping("/insert")
    public String replyInsertPOST(ReplyVO replyVO,BoardVO boardVO) {
        replyVO.setBoard_no(boardVO.getBoard_no());
        this.replyService.replyInsert(replyVO);
        return "redirect:/board/get?board_no="+replyVO.getBoard_no();
    }

    @GetMapping("/modify")
    public String replyContentsGET(@RequestParam(name = "reply_no") int reply_no,Model model){
        model.addAttribute("replyList" , replyService.replySelectNo(reply_no));
        return "replyUpDate";
    }
    @PostMapping("/modify")
    public String replyContentsPOST(ReplyVO replyVO){
        this.replyService.replymodify(replyVO);
        return "redirect:/board/list";
    }

    @GetMapping("/replydelete")
    public String boardDeleteGET(@RequestParam(name = "reply_no")int reply_no){
        replyService.replydelete(reply_no);
        return "redirect:/board/list";
    }


}
