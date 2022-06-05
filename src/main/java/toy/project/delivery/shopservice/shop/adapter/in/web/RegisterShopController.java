package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopCommand;
import toy.project.delivery.shopservice.shop.application.port.in.RegisterShopUseCase;

@RestController
@RequiredArgsConstructor
public class RegisterShopController {

    private final RegisterShopUseCase registerShopUseCase;
    private final RegisterShopMapper registerShopMapper;

    @PostMapping("/shops")
    public ResponseEntity<String> registerShop(
            @RequestBody RegisterShopDto registerShopDto
    ) {
        RegisterShopCommand registerShopCommand = registerShopMapper.mapToCommand(registerShopDto);

        registerShopUseCase.registerShop(registerShopCommand);

        return ResponseEntity.ok("success");
    }
}
