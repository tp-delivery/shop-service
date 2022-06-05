package toy.project.delivery.shopservice.shop.application.port.out;

import lombok.Value;

@Value(staticConstructor = "of")
public class CreateShopCommand {

    String name;

    String address;

    String phoneNumber;
}
