package com.example.board.Service;

import com.example.board.Mapper.MemberMapper;
import com.example.board.VO.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService{


    private final MemberMapper memberMapper;

    public MemberServiceImp(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void memberJoin(MemberVO member){
        memberMapper.memberJoin(member);
    }

    @Override
    public int idCheck(String memberId){
        return memberMapper.idCheck(memberId);
    }

    @Override
    public MemberVO memberLogin(MemberVO member) {
        return memberMapper.memberLogin(member);
    }
}
