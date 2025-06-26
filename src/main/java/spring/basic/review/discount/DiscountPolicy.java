package spring.basic.review.discount;

import spring.basic.review.member.Member;

public interface DiscountPolicy {
    Integer discount(Member member, Integer price);
}
