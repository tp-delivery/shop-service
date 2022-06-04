package toy.project.delivery.shopservice.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.project.delivery.shopservice.shop.application.port.in.GetAllShopsUseCase;
import toy.project.delivery.shopservice.shop.application.port.out.LoadAllShopsPort;
import toy.project.delivery.shopservice.shop.domain.Shop;

import java.util.List;

@Service
@RequiredArgsConstructor
class GetAllShopsService implements GetAllShopsUseCase {

    private final LoadAllShopsPort loadAllShopsPort;

    @Override
    public List<Shop> getAllShops() {
        return loadAllShopsPort.loadAllShops();
    }
}
