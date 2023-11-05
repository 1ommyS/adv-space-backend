package adv.space.repository;

import adv.space.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 1ommy
 * @version 05.11.2023
 */
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
}
