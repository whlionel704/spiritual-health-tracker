package tech.learns.lionel.spiritual_health_tracker.Services;
import tech.learns.lionel.spiritual_health_tracker.Dtos.MemberUpdateRequest;
import tech.learns.lionel.spiritual_health_tracker.Entities.Member;
import tech.learns.lionel.spiritual_health_tracker.Repositories.MemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberService {

    private final static Logger logger = Logger.getLogger(MemberService.class.getName());
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member create(Member member) {
        try {
            logger.log(Level.INFO, "🟢 creating new member");
            member.setJournals(new ArrayList<>());
            member.setCreatedAt(LocalDateTime.now().withNano(0));
            member.setAge(String.valueOf(LocalDateTime.now().getYear() - member.getBirthday().getYear()));
            logger.log(Level.INFO, "🟢 saving new member %s in the database", member);
            return memberRepository.save(member);
        } catch (Exception e) {
            logger.log(Level.WARNING, "🟠 Failed to create member: " + e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create member");
        }
    }

    public List<Member> getAll() {
        try {
            return memberRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to fetch members");
        }
    }

    public Member getMemberById(UUID id) {
        return memberRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Member not found with ID: " + id));
    }

    public Member updateMember(UUID id, MemberUpdateRequest updatedMember) {
        try {
            Member memberToUpdate = getMemberById(id);
            logger.log(Level.INFO, "🟢 updating member {0}", memberToUpdate);

            if (updatedMember.getBirthday() != null && 
                !updatedMember.getBirthday().toString().equals(memberToUpdate.getBirthday().toString())) {
                memberToUpdate.setBirthday(updatedMember.getBirthday().toString());
                memberToUpdate.setAge(String.valueOf(LocalDateTime.now().getYear() - updatedMember.getBirthday().getYear()));
            }

            if (updatedMember.getName() != null && 
                !updatedMember.getName().equals(memberToUpdate.getName())) {
                memberToUpdate.setName(updatedMember.getName());
            }

            if (updatedMember.getEmail() != null && 
                !updatedMember.getEmail().equals(memberToUpdate.getEmail())) {
                memberToUpdate.setEmail(updatedMember.getEmail());
            }

            if (updatedMember.getContact() != null && 
                !updatedMember.getContact().equals(memberToUpdate.getContact())) {
                memberToUpdate.setContact(updatedMember.getContact());
            }

            if (updatedMember.getHobbies() != null && 
                !updatedMember.getHobbies().equals(memberToUpdate.getHobbies())) {
                memberToUpdate.setHobbies(updatedMember.getHobbies());
            }

            logger.log(Level.INFO, "🟢 saving updated member {0} in the database", memberToUpdate);
            return memberRepository.save(memberToUpdate);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with ID: " + id);
        }
    }

    public boolean deleteMember(UUID id) {
        try {
            memberRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found with ID: " + id);
        }
    }
}