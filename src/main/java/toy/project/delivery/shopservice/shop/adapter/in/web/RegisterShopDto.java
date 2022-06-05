package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
class RegisterShopDto {
    private String name;

    private String address;

    private String phoneNumber;

    private RegisterShopDto(String name) {
        this.name = name;
    }

    public static RegisterShopDto of(String name, String address, String phoneNumber) {
        return new RegisterShopDto(name);
    }
}
