package toy.project.delivery.shopservice.shop.application.port.out;

import toy.project.delivery.shopservice.shop.domain.Shop;

public interface RegisterShopPort {
    Shop registerShop(String name);
}
