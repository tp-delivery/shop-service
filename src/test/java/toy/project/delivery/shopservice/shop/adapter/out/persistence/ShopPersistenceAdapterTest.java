package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopCommand;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import({ShopPersistenceAdapter.class, ShopMapper.class})
class ShopPersistenceAdapterTest {
    @Autowired
    private ShopPersistenceAdapter shopPersistenceAdapter;
    @Autowired
    private ShopRepository shopRepository;

    @Test
    @Sql("ShopPersistenceAdapterTest.sql")
    void loadAllShops() {
        int offset = 0;
        int max = 10;
        List<Shop> shops = shopPersistenceAdapter.loadAllShops(offset, max);

        assertThat(shops.size()).isEqualTo(10);
        assertThat(shops.get(0).getName()).isEqualTo("shop1");
    }

    @Test
    @Sql("ShopPersistenceAdapterTest.sql")
    void loadAllShops_offset1() {
        int offset = 1;
        int max = 10;
        List<Shop> shops = shopPersistenceAdapter.loadAllShops(offset, max);

        assertThat(shopRepository.count()).isEqualTo(12);

        assertThat(shops.size()).isEqualTo(2);
        assertThat(shops.get(0).getName()).isEqualTo("shop11");
    }

    @Test
    void createShop() {
        String name = "name";
        String address = "address";
        String phoneNumber = "phoneNumber";
        Shop shop = shopPersistenceAdapter.createShop(
                CreateShopCommand.of(name, address, phoneNumber)
        );

        assertThat(shop.getId()).isNotNull();
        assertThat(shop.getName()).isEqualTo(name);
        assertThat(shop.getAddress()).isEqualTo(address);
        assertThat(shop.getPhoneNumber()).isEqualTo(phoneNumber);
    }
}