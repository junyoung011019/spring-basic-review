package spring.basic.review.orderTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.basic.review.AppConfig;
import spring.basic.review.discount.FixDiscountPolicy;
import spring.basic.review.discount.RateDiscountPolicy;
import spring.basic.review.member.Grade;
import spring.basic.review.member.Member;
import spring.basic.review.member.MemberRepository;
import spring.basic.review.member.MemoryMemberRepository;
import spring.basic.review.order.Order;
import spring.basic.review.order.OrderService;
import spring.basic.review.order.OrderServiceIml;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class orderServiceTest {

    private  MemberRepository memberRepository;
    private OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberRepository = appConfig.memberRepository();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("일반 회원 주문 테스트")
    void orderBasicUserTest() {
        Member member = new Member(1L, "테스터", Grade.BASIC);
        memberRepository.save(member);

        Order order = orderService.orderProduct(1L, "신발", 129000);
        System.out.println(order.toString());
        assertThat(129000).isEqualTo(order.getProductPrice());
    }

    @Test
    @DisplayName("VIP 회원 주문 테스트")
    void orderVipUserTest() {
        Member member = new Member(1L, "테스터", Grade.VIP);
        memberRepository.save(member);

        Order order = orderService.orderProduct(1L, "신발", 129000);
        System.out.println(order.toString());
        assertThat(12900).isEqualTo(order.getDiscountPrice());
    }


}
