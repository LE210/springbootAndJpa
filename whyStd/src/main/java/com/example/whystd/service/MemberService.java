package com.example.whystd.service;

import com.example.whystd.domain.Member;
import com.example.whystd.repository.MemberRepository;
import com.example.whystd.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    // 서비스는 로직을 만드는 것
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 원본
//        Optional<Member> result =  memberRepository.findByName(member.getName());
//        // 그냥 꺼내고 싶으면 아래처럼 하면 되지만 권장하지는 않음
////        Member member1 = result.get();
//        result.ifPresent(item -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
    }

    // 중복 회원 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(item -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
            return memberRepository.findAll();
    }

    /**
     * 하나의 회원 찾기
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
