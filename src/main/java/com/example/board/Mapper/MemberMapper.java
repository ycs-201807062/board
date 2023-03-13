package com.example.board.Mapper;

import com.example.board.VO.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    //회원가입
     void memberJoin(MemberVO member);

    // 아이디 중복 검사
     int idCheck(String memberId);

    /* 로그인 */
     MemberVO memberLogin(MemberVO member);
}
