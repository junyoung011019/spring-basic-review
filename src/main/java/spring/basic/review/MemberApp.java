package spring.basic.review;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.basic.review.member.Grade;
import spring.basic.review.member.Member;
import spring.basic.review.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L,"테스터", Grade.BASIC);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("member1.getName() = " + member1.getName());
    }
}
