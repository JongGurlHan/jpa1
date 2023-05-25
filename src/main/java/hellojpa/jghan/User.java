package hellojpa.jghan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERTEST") //테이블 이름 설정
public class User {

    @Id
    private Long id;

    @Column(unique = true, length = 10)
    private String name;

    //JPA는 기본생성자 있어야 한다.
    public User(){
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
