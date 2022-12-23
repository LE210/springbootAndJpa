package com.example.whystd;

import com.example.whystd.aop.TimeTraceAop;
import com.example.whystd.repository.JdbcTemplateMemberRepository;
import com.example.whystd.repository.JpaMemberRepository;
import com.example.whystd.repository.MemberRepository;
import com.example.whystd.repository.MemoryMemberRepository;
import com.example.whystd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/


/*    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*
    * 스프링 빈을 직접 설정 할 때의 장점
    * : db 를 변경할때 repository 만 변경해주면 나머지
    * 코드를 손대지 않고 변경 가능.
    * */
    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

/*    // aop 직접등록법
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

/*
아래 처럼 변경해주면 끝
    @Bean
    public MemberRepository memberRepository() {
        return new DbMemberRepository();
    }
*/
}
