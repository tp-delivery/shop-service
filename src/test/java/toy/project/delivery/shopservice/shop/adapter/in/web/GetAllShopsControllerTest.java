package toy.project.delivery.shopservice.shop.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import toy.project.delivery.shopservice.shop.application.port.in.GetAllShopsUseCase;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GetAllShopsController.class)
class GetAllShopsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetAllShopsUseCase getAllShopsUseCase;
    @MockBean
    private GetAllShopsMapper getAllShopsMapper;

    @Test
    void getAllShops_without_offset_max() throws Exception {
        int defaultOffset = 0;
        int defaultMax = 10;
        List<Shop> shops = givenTwoShopList(0, 10);

        mockMvc.perform(get("/shops")
                .header("Content-Type", "application/json")
        ).andExpect(status().isOk());

        then(getAllShopsUseCase).should()
                .getAllShops(eq(defaultOffset), eq(defaultMax));

        then(getAllShopsMapper).should()
                .mapToWebModel(eq(shops));
    }

    @Test
    void getAllShops_with_offset_max() throws Exception {
        int offset = 0;
        int max = 10;
        List<Shop> shops = givenTwoShopList(offset, max);

        mockMvc.perform(get("/shops")
                .header("Content-Type", "application/json")
                .param("offset", Integer.toString(offset))
                .param("max", Integer.toString(max))
        ).andExpect(status().isOk());

        then(getAllShopsUseCase).should()
                .getAllShops(eq(offset), eq(max));

        then(getAllShopsMapper).should()
                .mapToWebModel(eq(shops));
    }

    private List<Shop> givenTwoShopList(int offset, int max) {
        List<Shop> shopList = List.of(givenShop(1L), givenShop(2L));
        given(getAllShopsUseCase.getAllShops(offset, max)).willReturn(shopList);
        return shopList;
    }


    private Shop givenShop(Long id) {
        Shop shop = Mockito.mock(Shop.class);
        given(shop.getId()).willReturn(id);
        return shop;
    }
}