package com.example.whystd.repository;

import com.example.whystd.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// 인터페이스가 인터페이스를 받을땐 확장
// 인터페이스는 다중 상속이 가능
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 끝남;
    @Override
    Optional<Member> findByName(String name);
}
