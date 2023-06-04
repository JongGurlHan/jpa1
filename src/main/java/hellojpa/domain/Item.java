package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn
public abstract class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
