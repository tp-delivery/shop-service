package toy.project.delivery.shopservice.shop.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "SHOPS")
@Getter
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private Shop(String name) {
        this.name = name;
    }

    public static Shop of(String name) {
        return new Shop(name);
    }

}
