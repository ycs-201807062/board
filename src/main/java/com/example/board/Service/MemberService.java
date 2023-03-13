package com.example.board.Service;

import com.example.board.VO.MemberVO;

public interface MemberService {

   void memberJoin(MemberVO member);
    // 아이디 중복 검사
    int idCheck(String memberId);

    /* 로그인 */
    MemberVO memberLogin(MemberVO member);
}
