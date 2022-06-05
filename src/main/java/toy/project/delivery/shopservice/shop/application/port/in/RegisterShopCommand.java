package toy.project.delivery.shopservice.shop.application.port.in;

import lombok.Value;

@Value(staticConstructor = "of")
public class RegisterShopCommand {

    String name;
}
