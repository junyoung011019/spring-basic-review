package spring.basic.review.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        Optional<Member> member = Optional.ofNullable(store.get(id));
        return member;
    }

}
