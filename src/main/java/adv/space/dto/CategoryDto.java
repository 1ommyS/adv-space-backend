package adv.space.dto;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.CategoryEntity}
 */
public record CategoryDto(long id, String title) implements Serializable {
}