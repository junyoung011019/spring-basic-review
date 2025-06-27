package spring.basic.review.memberTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.basic.review.AppConfig;
import spring.basic.review.member.*;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class memberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("회원가입")
    void 회원가입(){
        Member member = new Member(1L,"테스터", Grade.VIP);
        memberService.join(member);
    }

    @Test
    @DisplayName("아이디로 회원 찾기")
    void 회원찾기(){
        Member member = new Member(1L,"테스터1", Grade.VIP);
        memberService.join(member);
        assertThat(memberService.findMember(1L)).isEqualTo(member);
    }

    @Test
    @DisplayName("없는 회원 찾기")
    void 없는회원찾기(){
        assertThrows(NoSuchElementException.class,
                ()-> memberService.findMember(1L));
    }

}
