package com.example.board.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
    //회원 id
    private String memberId;

    //회원 비밀번호
    private String memberPw;

    //회원 이름
    private String memberName;

    //회원 이메일
    private String memberMail;

    //회원 우편번호
    private String memberAddr1;

    //회원 주소
    private String memberAddr2;

    //회원 상세주소
    private String memberAddr3;

    // 관리자 구분(0:일반사용자, 1:관리자)
    private int adminCk;

}
