package adv.space.dto.requests;

import adv.space.dto.responses.AdvertisementDto;
import adv.space.entity.UserEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link adv.space.entity.BargainEntity}
 */
public record CreateBargainDto(
        @NotNull AdvertisementDto advertisement,
        @NotNull UserEntity advertiser,

        @NotNull UserEntity customer,
        @Min(0) Double price
) implements Serializable {
}