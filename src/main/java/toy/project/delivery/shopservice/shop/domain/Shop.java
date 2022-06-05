package toy.project.delivery.shopservice.shop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Shop {
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    public static Shop of(Long id, String name, String address, String phoneNumber) {
        Shop shop = new Shop();
        shop.id = id;
        shop.name = name;
        shop.address = address;
        shop.phoneNumber = phoneNumber;
        return shop;
    }
}
