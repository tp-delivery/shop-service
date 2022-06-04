package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.Getter;
import toy.project.delivery.shopservice.shop.domain.Shop;

@Getter
class ShopDto {
    private final Long id;
    private final String name;

    private ShopDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ShopDto of(Shop state) {
        return new ShopDto(state.getId(), state.getName());
    }


}
