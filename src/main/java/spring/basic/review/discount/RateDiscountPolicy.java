package spring.basic.review.discount;

import spring.basic.review.member.Grade;
import spring.basic.review.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    @Override
    public Integer discount(Member member, Integer price) {
        if(member.getGrade()== Grade.VIP){
            return (int) (price*0.1);
        }else {
            return 0;
        }
    }
}
