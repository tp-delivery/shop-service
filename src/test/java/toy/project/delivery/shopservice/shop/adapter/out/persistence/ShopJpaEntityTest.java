package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShopJpaEntityTest {

    @Test
    void builderTest() {
        ShopJpaEntity entity = ShopJpaEntity.builder()
                .name("name")
                .address("address")
                .phoneNumber("phoneNumber")
                .build();

        assertThat(entity.getName()).isEqualTo("name");
        assertThat(entity.getAddress()).isEqualTo("address");
        assertThat(entity.getPhoneNumber()).isEqualTo("phoneNumber");
    }

}