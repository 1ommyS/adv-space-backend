package adv.space.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.CategoryEntity}
 */
public record CreateCategoryDto(
        @NotEmpty(message = "Название неможет быть пустым") @Length(message = "Длина названия категории должна быть в диапазоне от 1 до 50 символов", min = 1, max = 50) String title) implements Serializable {
}