package spring.basic.review;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.basic.review.member.Grade;
import spring.basic.review.member.Member;
import spring.basic.review.member.MemberRepository;
import spring.basic.review.member.MemberService;
import spring.basic.review.order.Order;
import spring.basic.review.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L,"테스터", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.orderProduct(1L, "신발", 130000);
        System.out.println(order);
    }
}
