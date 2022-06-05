package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
class RegisterShopDto {
    private String name;

    private RegisterShopDto(String name) {
        this.name = name;
    }

    public static RegisterShopDto of(String name) {
        return new RegisterShopDto(name);
    }
}
