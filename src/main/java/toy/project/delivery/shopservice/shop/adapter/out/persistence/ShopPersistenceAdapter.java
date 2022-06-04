package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toy.project.delivery.shopservice.shop.application.port.out.LoadAllShopsPort;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class ShopPersistenceAdapter implements LoadAllShopsPort {

    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;

    @Override
    public List<Shop> loadAllShops() {

        List<ShopJpaEntity> shopJpaEntityList = shopRepository.findAll();

        return shopJpaEntityList.stream()
                .map(shopMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
