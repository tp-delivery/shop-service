package toy.project.delivery.shopservice.shop.adapter.out.persistence;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SHOPS")
@Getter
@NoArgsConstructor
class ShopJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    private ShopJpaEntity(String name) {
        this.name = name;
    }

    public static ShopJpaEntity of(String name) {
        return new ShopJpaEntity(name);
    }
}
