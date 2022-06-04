package toy.project.delivery.shopservice.shop.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface ShopRepository extends JpaRepository<ShopJpaEntity, Long> {
}
