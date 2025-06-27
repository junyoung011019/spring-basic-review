package spring.basic.review.order;

import spring.basic.review.discount.DiscountPolicy;
import spring.basic.review.discount.FixDiscountPolicy;
import spring.basic.review.discount.RateDiscountPolicy;
import spring.basic.review.member.Member;
import spring.basic.review.member.MemberRepository;
import spring.basic.review.member.MemoryMemberRepository;

import java.util.Optional;

public class OrderServiceIml implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceIml(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order orderProduct(Long id, String productName, Integer productPrice) {
        Member member = memberRepository.findById(id).get();
        Integer discountPrice = discountPolicy.discount(member, productPrice);
        return new Order(id, productName, productPrice, discountPrice);
    }

}
