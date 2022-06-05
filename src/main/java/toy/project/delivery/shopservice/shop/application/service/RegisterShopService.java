package toy.project.delivery.shopservice.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopUseCase;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopCommand;
import toy.project.delivery.shopservice.shop.application.port.out.CreateShopPort;

@Service
@Transactional
@RequiredArgsConstructor
class RegisterShopService implements RegisterShopUseCase {
    private final CreateShopPort createShopPort;

    @Override
    public void registerShop(RegisterShopCommand command) {
        createShopPort.createShop(CreateShopCommand.of(
                command.getName(),
                command.getAddress(),
                command.getPhoneNumber()
        ));
    }
}
