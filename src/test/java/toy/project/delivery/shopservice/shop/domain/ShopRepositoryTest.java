package toy.project.delivery.shopservice.shop.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
class ShopRepositoryTest {

    @Container
    static GenericContainer genericContainer = new GenericContainer("mysql");
    @Autowired
    ShopRepository shopRepository;

    @Test
    @DisplayName("가게 생성")
    @Transactional
    void save() {
        Shop shop = Shop.of("test");

        shopRepository.save(shop);
    }
}