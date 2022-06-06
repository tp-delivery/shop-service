package toy.project.delivery.shopservice.shop.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopUseCase;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RegisterShopController.class)
class RegisterShopControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterShopUseCase registerShopUseCase;
    @MockBean
    private RegisterShopMapper registerShopMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerShop() throws Exception {
        RegisterShopDto registerShopDto = RegisterShopDto.builder()
                .name("name")
                .address("address")
                .phoneNumber("phoneNuber")
                .build();
        RegisterShopCommand registerShopCommand = RegisterShopCommand.of("name", "address", "phoneNumber");

        given(registerShopMapper.mapToCommand(registerShopDto))
                .willReturn(registerShopCommand);

        mockMvc.perform(post("/shops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerShopDto))
                ).andExpect(status().isOk())
                .andExpect(content().string("success"));

        then(registerShopMapper).should()
                .mapToCommand(eq(registerShopDto));

        then(registerShopUseCase).should()
                .registerShop(eq(registerShopCommand));
    }

}