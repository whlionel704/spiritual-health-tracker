package tech.learns.lionel.spiritual_health_tracker.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.learns.lionel.spiritual_health_tracker.Entities.Member;
import tech.learns.lionel.spiritual_health_tracker.Services.MemberService;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping({"","/"})
    public Member create(@RequestBody Member member) {
        return service.create(member);
    }

    @GetMapping({"","/"})
    public List<Member> getAll() {
        return service.getAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    public Member getById(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public Member update(@PathVariable Long id, @RequestBody Member member) {
        return service.updateMember(id, member);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public Boolean delete(@PathVariable Long id) {
        return service.deleteMember(id);
    }

}