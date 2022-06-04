package toy.project.delivery.shopservice.shop.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import toy.project.delivery.shopservice.shop.application.port.out.LoadAllShopsPort;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class GetAllShopsServiceTest {

    private final LoadAllShopsPort loadAllShopsPort = Mockito.mock(LoadAllShopsPort.class);

    private final GetAllShopsService getAllShopsService =
            new GetAllShopsService(loadAllShopsPort);

    @Test
    void givenEmptyShopList_thenEmptyResult() {
        givenEmptyShopList();

        List<Shop> allShops = getAllShopsService.getAllShops();

        assertThat(allShops).isEmpty();
    }

    @Test
    void givenTwoShopList_thenSameResult() {
        List<Shop> shopList = givenTwoShopList();

        List<Shop> allShops = getAllShopsService.getAllShops();

        assertThat(allShops).isEqualTo(shopList);
    }

    private void givenEmptyShopList() {
        given(loadAllShopsPort.loadAllShops()).willReturn(List.of());
    }

    private List<Shop> givenTwoShopList() {
        List<Shop> shopList = List.of(givenShop(1L), givenShop(2L));
        given(loadAllShopsPort.loadAllShops()).willReturn(shopList);
        return shopList;
    }

    private Shop givenShop(Long id) {
        Shop shop = Mockito.mock(Shop.class);
        given(shop.getId()).willReturn(id);
        return shop;
    }

}