package session.toyPjV0.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import session.toyPjV0.entity.Member;
import session.toyPjV0.entity.MemberDto;
import session.toyPjV0.entity.Team;
import session.toyPjV0.repository.MemberRepository;
import session.toyPjV0.repository.TeamRepository;

import java.util.List;

@RestController
@RequestMapping("/toyPjV0")
@RequiredArgsConstructor
public class ApiController {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostConstruct
    public void init(){
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);
        memberRepository.save(new Member("철수",23,teamA));
        memberRepository.save(new Member("개똥이",24,teamB));
    }

    // api로 할때 전체 목록은 어떻게 보여주지?
    @GetMapping("/members")
    public List<MemberDto> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(m -> new MemberDto(m.getId(), m.getUsername(), m.getAge(), m.getTeam().getName()))
                .toList();
    }

    // 개별 조회
    // 컨트롤러
    @GetMapping("/members/{member_id}")
    public MemberDto findMember(@PathVariable("member_id") Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found id=" + memberId));

        return new MemberDto(
                member.getId(),
                member.getUsername(),
                member.getAge(),
                member.getTeam().getName()
        );
    }

}
