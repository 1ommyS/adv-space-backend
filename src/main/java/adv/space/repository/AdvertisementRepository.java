package adv.space.repository;

import adv.space.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author 1ommy
 * @version 05.11.2023
 */
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
    List<AdvertisementEntity> findByOwner_Id(Long id);
}
