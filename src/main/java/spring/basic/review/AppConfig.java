package spring.basic.review;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.basic.review.discount.DiscountPolicy;
import spring.basic.review.discount.FixDiscountPolicy;
import spring.basic.review.discount.RateDiscountPolicy;
import spring.basic.review.member.*;
import spring.basic.review.order.Order;
import spring.basic.review.order.OrderService;
import spring.basic.review.order.OrderServiceIml;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceIml(memberRepository(), discountPolicy());
    }

}
