package adv.space.repository;

import adv.space.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author 1ommy
 * @version 30.10.2023
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByTitle(String title);

}