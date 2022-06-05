package toy.project.delivery.shopservice.shop.application.port.out;

import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

public interface LoadAllShopsPort {

    List<Shop> loadAllShops(int offset, int max);
}
