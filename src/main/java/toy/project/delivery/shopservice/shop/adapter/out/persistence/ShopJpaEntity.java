package toy.project.delivery.shopservice.shop.adapter.out.persistence;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SHOPS")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
class ShopJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 20)
    private String phoneNumber;

}
