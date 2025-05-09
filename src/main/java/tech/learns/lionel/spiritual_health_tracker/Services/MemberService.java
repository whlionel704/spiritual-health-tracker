package tech.learns.lionel.spiritual_health_tracker.Services;
import tech.learns.lionel.spiritual_health_tracker.Entities.Member;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    // private final MemberRepository repo;
    private final List<Member> members = new ArrayList<>();

    // public MemberService(MemberRepository repo) {
    //     this.repo = repo;
    // }

    public Member create(Member member) {
        members.add(member);
        return member;
    }

    public List<Member> getAll() {
        return members;
    }

    public Member getMemberById(Long id) {
        return members.stream()
                      .filter(member -> member.getId().equals(id))
                      .findFirst()
                      .orElse(null);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Member memberToUpdate = getMemberById(id);
        memberToUpdate.setAge(updatedMember.getAge());
        memberToUpdate.setName(updatedMember.getName());
        memberToUpdate.setEmail(updatedMember.getEmail());
        memberToUpdate.setContact(updatedMember.getContact());
        memberToUpdate.setHobbies(updatedMember.getHobbies());
        return memberToUpdate;
    }

    public boolean deleteMember(Long id) {
        return members.removeIf(member -> member.getId().equals(id));
    }
}