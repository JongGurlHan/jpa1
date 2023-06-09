package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "parent")
    private List<Child> childList = new ArrayList<>();

    //연관관계 편의메소드 - 양방향 모두 세팅
    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }


    private String name;

}
