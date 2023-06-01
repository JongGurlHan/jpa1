package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column
    private String name;

//    @OneToMany(mappedBy = "team")//mappedy by: 나는 Member클래스의 team변수에 매핑됐다.
//    private List<Member> members = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();


//    public void addMember(Member member) {
//        member.setTeam(this);
//        members.add(member);
//    }
}
