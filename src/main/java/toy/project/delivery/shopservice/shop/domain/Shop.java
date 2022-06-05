package toy.project.delivery.shopservice.shop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Shop {
    private Long id;

    private String name;

    public static Shop of(Long id, String name) {
        Shop shop = new Shop();
        shop.id = id;
        shop.name = name;
        return shop;
    }
}
