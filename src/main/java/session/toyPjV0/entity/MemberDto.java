package session.toyPjV0.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String usename;
    private int age;
    private String teamName;
}
