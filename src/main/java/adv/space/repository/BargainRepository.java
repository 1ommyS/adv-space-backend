package adv.space.repository;

import adv.space.entity.BargainEntity;
import adv.space.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 1ommy
 * @version 16.11.2023
 */
public interface BargainRepository extends JpaRepository<BargainEntity, Long> {
    List<BargainEntity> findByAdvertiserAndCustomer(UserEntity advertiser, UserEntity customer);


}
