package session.toyPjV0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import session.toyPjV0.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
