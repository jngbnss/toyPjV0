package session.toyPjV0.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import session.toyPjV0.repository.MemberRepository;
import session.toyPjV0.repository.TeamRepository;

@RestController
@RequestMapping("/toyPjV0")
@RequiredArgsConstructor
public class ApiController {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    // api로 할때 전체 목록은 어떻게 보여주지?
//    @GetMapping
//    public
    // 개별 조회
    @GetMapping("/{member_id}")
    public void member
}
