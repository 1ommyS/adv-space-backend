package adv.space.dto.responses;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.AreaEntity}
 */
public record AreaDto(@NotNull Long id, String title, String link) implements Serializable {
}