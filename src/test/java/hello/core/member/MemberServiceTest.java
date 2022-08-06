package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when  // member를 회원가입한 경우
        memberService.join(member);
        // id를 가진 member를 찾는 member 객체 생성
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
