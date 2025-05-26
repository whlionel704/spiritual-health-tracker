package tech.learns.lionel.spiritual_health_tracker.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tech.learns.lionel.spiritual_health_tracker.Dtos.MemberUpdateRequest;
import tech.learns.lionel.spiritual_health_tracker.Entities.Member;
import tech.learns.lionel.spiritual_health_tracker.Services.MemberService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    //Todo: for post, put and delete endpoints, add authentication so that only authenticated users can create, update or delete members.
    @PostMapping({"","/"})
    public Member create(@RequestBody Member member) {
        return service.create(member);
    }

    @GetMapping({"","/"})
    public List<Member> getAll() {
        return service.getAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    public Member getById(@PathVariable UUID id) {
        return service.getMemberById(id);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public Member update(@PathVariable UUID id, @RequestBody MemberUpdateRequest member) {
        return service.updateMember(id, member);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public Boolean delete(@PathVariable UUID id) {
        return service.deleteMember(id);
    }

}