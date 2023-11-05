package adv.space.repository;

import adv.space.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>,
        JpaSpecificationExecutor<CompanyEntity> {
    Optional<CompanyEntity> findByTitle(String title);

}