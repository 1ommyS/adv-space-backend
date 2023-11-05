package adv.space.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.CategoryEntity}
 */
public record CategoryDto(@NotNull Long id, String title) implements Serializable {
}