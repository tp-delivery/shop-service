package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.*;

@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
class RegisterShopDto {
    private String name;

    private String address;

    private String phoneNumber;
}
