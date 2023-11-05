package adv.space.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.CompanyEntity}
 */
public record CompanyDto(@NotNull Long id, @NotBlank String title, @NotBlank String description, String iconUrl,
                         UserDto delegate) implements Serializable {
}