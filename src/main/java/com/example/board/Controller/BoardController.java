package com.example.board.Controller;

import com.example.board.Service.BoardService;
import com.example.board.Service.MemberService;
import com.example.board.Service.ReplyService;
import com.example.board.VO.BoardVO;
import com.example.board.VO.Criteria;
import com.example.board.VO.MemberVO;
import com.example.board.VO.PageMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping({"/board/*"})// 이 컨트롤러에 있는 Mapping앞에 /board/를 붙인다
public class BoardController {
    @Autowired // BoardService타입에 해당하는 객체 빈을 주입해준다
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;

    @Autowired
    private MemberService memberService;



    public BoardController() {
    }

    @GetMapping({"/list"}) //board/list 부분 (게시판 리스트)
    public String boardListGET(Model model, Criteria cri , HttpSession session ,MemberVO memberVO) { // 화면의 정보인 Model과 페이지 정보를 갖는 Criteria를 밭는다.

        model.addAttribute("member",session.getAttribute("member"));
        model.addAttribute("list", boardService.getListPaging(cri)); // 모델에 getListPaging한 값을 list의 이름을 붙여 뷰에 전송한다.
        int total = boardService.getTotal(cri);                                 // 타이틀이 몇개있나 즉, 개시물의 갯수를 total에 담는다.
        PageMaker pageMaker = new PageMaker(cri,total);                         // 페이지 정보와 게시물의 갯수를 받아 페이지 마커를 생성한다.
        model.addAttribute("pageMaker",pageMaker);                  //모델에 페이지마커를 pageMaker이름을 붙여 뷰에 전송한다.
        return "list";                                                          // model 방식이기 때문에 동작할 HTML 파일의 이름을 리턴해준다.
    }




    @GetMapping({"/enroll"})                                                 //board/enroll 부분 (게시물 추가)
    public String boardEnrollGET(Model model ,HttpSession session) {
        model.addAttribute("member",session.getAttribute("member"));
        return "enroll";                                                        // 동작할 HTML 파일의 이름을 리턴해준다.
    }

    @PostMapping({"/enroll"})                                                //board/enroll 부분 (게시물 추가) 실질적인 동작부분
    public String boardEnrollPOST(BoardVO boardVO,RedirectAttributes rttr) {    // boardVO에 있는 정보들을 뷰에서 받아사용 RedirectAttributes는 JS로 동작이 완료되었을 경우 alert()를 사용하여 알림창을 띄워주기 위하여 사용했다.
        this.boardService.enroll(boardVO);                                      //뷰에서 받은 VO정보들을 boardService.enroll로 데이터베이스에 추가시킨다.
        rttr.addFlashAttribute("result","enroll success"); // 뷰부분에 JS를 사용하여 알림창을 띄워줄것이기에 addFlashAttribute를 사용하여 result값에 enroll success값을 메모리 값으로 저장시킨다.
        return "redirect:list";                                                   // redirect를 사용하여 list를 바로 호출해준다.
    }

    /* 게시판 상세 조회 */
    @GetMapping("/get")                                                         //페이지 상세조회부분이다.
    public String boardGetPageGET(@RequestParam(name = "board_no") int id, Model model,HttpSession session) { // RequestParam을 통하여 board_no의 값을 받아 id로 저장하고 페이지 부분을 가지고온다

        if (session.getAttribute("member")!=null) {
            model.addAttribute("member", session.getAttribute("member"));//RequestParam을 통해 값을 전달받을 경우 뷰부분에서 직접 값을 넘겨주거나 ajax등을 사용해 넘겨주는방법이 있다,
        }

        model.addAttribute("pageInfo", boardService.get(id));               // model에 id에 맞는 게시물 DB정보들을 pageInfo 이름에 담아 추가한다(뷰에 전송한다.
        model.addAttribute("reply",replyService.replySelect(id));           // model에 id에 맞는 댓글 DB정보들을 reply 이름에 담아 추가한다(뷰에 전송한다.
        return "get";                                                                   // 동작할 HTML 파일의 이름을 리턴해준다.
    }


    @GetMapping("/modify")                                                              //게시판 수정부분이다.
    public String boardModifyGET(@RequestParam(name = "board_no") int id, Model model,HttpSession session) {  //값을 가지고오는것은 get과 동일하다
        model.addAttribute("member",session.getAttribute("member"));
        model.addAttribute("pageInfo", boardService.get(id));
        return "modify";
    }
    @PostMapping("/modify")                                                             //실질적인 게시판 수정부분이다.
    public String boardModifyPOST(BoardVO board,RedirectAttributes rttr) {                 //boardVO에 있는 정보들을 뷰에서 받아사용한다. RedirectAttributes는
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
/*기본적인 AJAX 바탕
$.ajax({
  url: '주소',
  type: 'get 또는 post',
  data: {
    // 보낼 데이터
  },
  dataType: 'json, xml, script, text 또는 html',
  done: function(response) {
    // 성공 시 동작
  },
  fail: function(error) {
    // 실패 시 동작
  },
  always: function(response) {
    // 성공하든 실패하든 항상 할 동작
  }
});*/
