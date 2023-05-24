package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id
    private Long id;
    private String name;

    //JPA는 기본생성자 있어야 한다.
    public Member(){
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
