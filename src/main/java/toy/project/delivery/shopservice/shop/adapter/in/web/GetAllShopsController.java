package toy.project.delivery.shopservice.shop.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toy.project.delivery.shopservice.shop.application.port.in.GetAllShopsUseCase;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllShopsController {

    private final GetAllShopsUseCase getAllShopsUseCase;
    private final GetAllShopsMapper getAllShopsMapper;

    @GetMapping("/shops")
    public ResponseEntity<GetAllShopsDto> getAllShops(
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "10") int max
    ) {
        List<Shop> shops = getAllShopsUseCase.getAllShops(offset, max);

        GetAllShopsDto getAllShopsDto = getAllShopsMapper.mapToWebModel(shops);

        return ResponseEntity.ok(getAllShopsDto);
    }
}
