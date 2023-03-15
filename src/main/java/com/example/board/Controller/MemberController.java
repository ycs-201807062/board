package com.example.board.Controller;

import com.example.board.Service.MemberService;
import com.example.board.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {
    @Autowired
    private MemberService memberService;

    //회원가입 페이지 이동
    @GetMapping({"/join"})
    public String memberJoinGET() {
        return "join";
    }
    @PostMapping("/join")
    public String memberJoinPost(MemberVO memberVO){

        memberService.memberJoin(memberVO);

        return ("login");
    }

    //로그인 페이지 이동
    @GetMapping({"/login"})
    public String memberLoginGET() {
        return "login";
    }
    // 아이디 중복 검사
    @RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
    @ResponseBody
    public String memberIdChkPOST(String memberId){

        int result = memberService.idCheck(memberId);


        if(result != 0) {

            return "fail";	// 중복 아이디가 존재

        } else {

            return "success";	// 중복 아이디 x

        }

    } // memberIdChkPOST() 종료
    
    
    @PostMapping("login")
    public String loginPost(HttpServletRequest request, MemberVO memberVO , RedirectAttributes rttr){
//        System.out.println("login 메서드 진입");
//        System.out.println("전달된 데이터" + memberVO);

        HttpSession Session = request.getSession();
        MemberVO lvo = memberService.memberLogin(memberVO);

        if(lvo == null) {                                // 일치하지 않는 아이디, 비밀번호 입력 경우

            int result = 0;
            rttr.addFlashAttribute("result", result);
            return "redirect:/member/login";

        }

        Session.setAttribute("member", lvo);             // 일치하는 아이디, 비밀번호 경우 (로그인 성공)
        Session.setMaxInactiveInterval(60);

        return "redirect:/board/list";
    }
    /* 메인페이지 로그아웃 */
    @RequestMapping(value="logout.do", method= RequestMethod.GET)
    public String logoutMainGET(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/board/list";

    }

    @RequestMapping(value="logout.do", method= RequestMethod.POST)
    @ResponseBody
    public void logoutMainPOST(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();


    }

}
