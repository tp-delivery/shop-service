package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.Value;

@Value(staticConstructor = "of")
class ShopDto {
    Long id;
    String name;
    String address;
    String phoneNumber;
}
