package toy.project.delivery.shopservice.shop.application.port.in;

import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

public interface GetAllShopsUseCase {

    List<Shop> getAllShops(int offset, int max);
}
