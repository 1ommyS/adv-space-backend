package adv.space.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.CompanyEntity}
 */
public record CompanyDto(Long id, @NotBlank String title, @NotBlank String description, @NotBlank String iconUrl,
                         UserDto delegate) implements Serializable {
}