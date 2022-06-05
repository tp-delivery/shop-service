package toy.project.delivery.shopservice.shop.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;
import toy.project.delivery.shopservice.shop.application.port.out.RegisterShopPort;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;

class RegisterShopServiceTest {
    private final RegisterShopPort registerShopPort = Mockito.mock(RegisterShopPort.class);

    private final RegisterShopService registerShopService =
            new RegisterShopService(registerShopPort);

    @Test
    void registerShop() {
        RegisterShopCommand command = RegisterShopCommand.of("test");

        registerShopService.registerShop(command);

        then(registerShopPort).should()
                .registerShop(eq("test"));
    }
}