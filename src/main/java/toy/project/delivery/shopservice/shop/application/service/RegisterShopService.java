package toy.project.delivery.shopservice.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopUseCase;
import toy.project.delivery.shopservice.shop.application.port.out.RegisterShopPort;

@Service
@RequiredArgsConstructor
class RegisterShopService implements RegisterShopUseCase {
    private final RegisterShopPort registerShopPort;

    @Override
    public void registerShop(RegisterShopCommand command) {
        registerShopPort.registerShop(command.getName());
    }
}
