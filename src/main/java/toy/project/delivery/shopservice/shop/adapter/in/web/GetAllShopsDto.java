package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.Getter;

import java.util.List;

@Getter
class GetAllShopsDto {
    private final List<ShopDto> shops;

    private GetAllShopsDto(List<ShopDto> shops) {
        this.shops = shops;
    }

    public static GetAllShopsDto of(List<ShopDto> shops) {
        return new GetAllShopsDto(shops);
    }
}
