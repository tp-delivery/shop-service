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

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 20, unique = true)
    private String phoneNumber;

}
