package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
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

        assertThat(shops.size()).isEqualTo(2);
        assertThat(shops.get(0).getName()).isEqualTo("shop11");
    }

    @Test
    void registerShop() {
        String name = "new_shop";
        Shop shop = shopPersistenceAdapter.registerShop(name);

        assertThat(shop.getId()).isNotNull();
        assertThat(shop.getName()).isEqualTo(name);
    }
}