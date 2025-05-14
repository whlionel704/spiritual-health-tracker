package tech.learns.lionel.spiritual_health_tracker.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.learns.lionel.spiritual_health_tracker.Entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {}