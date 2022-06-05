package toy.project.delivery.shopservice.shop.adapter.in.web;

import org.springframework.stereotype.Component;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;

@Component
class RegisterShopMapper {
    public RegisterShopCommand mapToCommand(RegisterShopDto registerShopDto) {
        return RegisterShopCommand.of(registerShopDto.getName());
    }
}
