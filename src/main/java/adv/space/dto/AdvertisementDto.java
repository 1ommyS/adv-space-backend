package adv.space.dto;

import adv.space.entity.AdvertisementEntity;
import adv.space.entity.TagEntity;
import adv.space.enums.TypeOfAdvertisement;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link AdvertisementEntity}
 */
public record AdvertisementDto(Long id, @NotBlank String title, @NotBlank String content, @Min(0) int price,
                               CompanyDto company, CategoryDto category, List<TagEntity> tags, AreaDto area,
                               UserDto owner, TypeOfAdvertisement type) implements Serializable {
}