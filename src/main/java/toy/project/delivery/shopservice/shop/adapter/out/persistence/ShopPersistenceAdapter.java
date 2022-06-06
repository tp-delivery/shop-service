package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopCommand;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopPort;
import toy.project.delivery.shopservice.shop.application.port.out.LoadAllShopsPort;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class ShopPersistenceAdapter implements LoadAllShopsPort, CreateShopPort {
    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;

    @Override
    public List<Shop> loadAllShops(int offset, int max) {
        Page<ShopJpaEntity> shopJpaEntityPage = shopRepository.findAll(PageRequest.of(offset, max));

        return shopJpaEntityPage.stream()
                .map(shopMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Shop createShop(CreateShopCommand command) {
        ShopJpaEntity entity = ShopJpaEntity.builder()
                .name(command.getName())
                .address(command.getAddress())
                .phoneNumber(command.getPhoneNumber())
                .build();
        ShopJpaEntity saved = shopRepository.save(entity);
        return shopMapper.mapToDomainEntity(saved);
    }
}
