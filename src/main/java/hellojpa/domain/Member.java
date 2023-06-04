package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


//    @ManyToOne //연관관계의 주인
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    //연관관계 편의 메소드
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

    //    @Column(name = "TEAM_ID")
//    private Long teamId;



//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
//    private String username;

//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;

/*    @Id
    private Long id;
    private String name;

    //JPA는 기본생성자 있어야 한다.
    public Member(){
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }*/
}