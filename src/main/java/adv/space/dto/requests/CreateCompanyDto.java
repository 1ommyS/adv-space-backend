package adv.space.dto.requests;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.CompanyEntity}
 */
public record CreateCompanyDto(@NotBlank String title, @NotBlank String description, MultipartFile icon,
                               Long delegateId) implements Serializable {
}