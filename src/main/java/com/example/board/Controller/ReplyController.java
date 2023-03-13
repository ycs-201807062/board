package com.example.board.Controller;

import com.example.board.Service.ReplyService;
import com.example.board.VO.BoardVO;
import com.example.board.VO.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reply/*")                                         //댓글부분으로 해당컨트롤러에서 Mapping되는 것들 앞에 /reply/를 붙여준다
public class ReplyController {

    @Autowired
    ReplyService replyService;                                          //replyService타입에 해당하는 객체 빈을 주입해준다
    @PostMapping("/insert")                                            //댓글 생성부분이다.
    public String replyInsertPOST(ReplyVO replyVO,BoardVO boardVO) {    //ReplyVO BoardVO 댓글정보와 게시물 정보들을 받아사용한다.
        replyVO.setBoard_no(boardVO.getBoard_no());                     //get페이지에서 동작하기 떄문에 바로 호출해주기위해 replyVo에담아준다
        this.replyService.replyInsert(replyVO);                         //댓글 작성부분
        return "redirect:/board/get?board_no="+replyVO.getBoard_no();   //get페이지 바로 호출
    }

    @GetMapping("/modify")                                                                              //댓글 수정부분(게시판 상세보기와 유사하다.
    public String replyContentsGET(@RequestParam(name = "reply_no") int reply_no,Model model){             //RequestParam을 사용하여 reply_no를 받고 Model값을받아사용한다
        model.addAttribute("replyList" , replyService.replySelectNo(reply_no));                 //replyList에 원래 가지고 있던 댓글부분을 replyList에 담아 뷰에 전송한다.
        return "replyUpDate";
    }
    @PostMapping("/modify")                                                                                //실질적인 게시판 수정부분
    public String replyContentsPOST(ReplyVO replyVO){                                                         //댓글의 정보를받아 사용한다.
        this.replyService.replymodify(replyVO);                                                               //DB에 접근하여 댓글을 수정한다.
        return "redirect:/board/list";                                                                        //redirect를 사용하여 바로 list를 호출한다.
    }

    @GetMapping("/replydelete")                                                                             //댓글 삭제기능 부분
    public String boardDeleteGET(@RequestParam(name = "reply_no")int reply_no){                                //댓글 번호를 가지고와서 사용한다.
        replyService.replydelete(reply_no);                                                                    //DB에서 삭제한다.
        return "redirect:/board/list";                                                                         //redirect를 사용하여 바로 list를 호출한다.
    }


}
