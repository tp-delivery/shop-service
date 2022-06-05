package toy.project.delivery.shopservice.shop.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopCommand;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopPort;

import static org.mockito.BDDMockito.then;

class RegisterShopServiceTest {
    private final CreateShopPort createShopPort = Mockito.mock(CreateShopPort.class);

    private final RegisterShopService registerShopService =
            new RegisterShopService(createShopPort);

    @Test
    void registerShop() {
        RegisterShopCommand command = RegisterShopCommand.of("name", "address", "phoneNumber");

        registerShopService.registerShop(command);

        then(createShopPort).should()
                .createShop(CreateShopCommand.of("name", "address", "phoneNumber"));
    }
}