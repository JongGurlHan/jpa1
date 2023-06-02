package hellojpa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "Item_ID")
    private Item product;

    @OneToOne
    @JoinColumn(name="Delivery_ID")
    private Delivery delivery;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
