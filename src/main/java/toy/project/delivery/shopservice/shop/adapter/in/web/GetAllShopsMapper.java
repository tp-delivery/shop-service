package toy.project.delivery.shopservice.shop.adapter.in.web;

import org.springframework.stereotype.Component;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;
import java.util.stream.Collectors;

@Component
class GetAllShopsMapper {

    public GetAllShopsDto mapToWebModel(List<Shop> shopList) {
        return GetAllShopsDto.of(
                shopList.stream()
                        .map(shop -> ShopDto.of(
                                shop.getId(),
                                shop.getName(),
                                shop.getAddress(),
                                shop.getPhoneNumber())
                        )
                        .collect(Collectors.toList())
        );
    }

}
