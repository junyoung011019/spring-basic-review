package spring.basic.review.discount;

import spring.basic.review.member.Grade;
import spring.basic.review.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private Integer discountPrice = 1000;

    @Override
    public Integer discount(Member member, Integer price) {
        if(member.getGrade()== Grade.VIP){
            return discountPrice;
        }else {
            return 0;
        }
    }
}
