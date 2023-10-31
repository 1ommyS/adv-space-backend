package adv.space.dto;

import adv.space.entity.AreaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * DTO for {@link AreaEntity}
 */
public record AreaEntityDto(Long id, @Size @NotBlank String title,
                            @NotBlank @URL(message = "Адрес не должен быть пустым", protocol = "https://") String link) implements Serializable {
}