package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import org.springframework.stereotype.Component;
import toy.project.delivery.shopservice.shop.domain.Shop;

@Component
class ShopMapper {
    public Shop mapToDomainEntity(ShopJpaEntity shop) {
        return Shop.of(shop.getId(), shop.getName(), shop.getAddress(), shop.getPhoneNumber());
    }
}
