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
    void getAllShops() throws Exception {
        List<Shop> shops = givenTwoShopList();

        mockMvc.perform(get("/shops")
                .header("Content-Type", "application/json")
        ).andExpect(status().isOk());

        then(getAllShopsUseCase).should()
                .getAllShops();

        then(getAllShopsMapper).should()
                .mapToWebModel(eq(shops));
    }

    private List<Shop> givenTwoShopList() {
        List<Shop> shopList = List.of(givenShop(1L), givenShop(2L));
        given(getAllShopsUseCase.getAllShops()).willReturn(shopList);
        return shopList;
    }


    private Shop givenShop(Long id) {
        Shop shop = Mockito.mock(Shop.class);
        given(shop.getId()).willReturn(id);
        return shop;
    }
}