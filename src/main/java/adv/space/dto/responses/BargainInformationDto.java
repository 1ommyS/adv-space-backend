package adv.space.dto.responses;

import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link adv.space.entity.BargainEntity}
 */
public record BargainInformationDto(Long id, AdvertisementDto advertisement, AdvertisementDto advertiser,
                                    AdvertisementDto customer, @Min(0) Double price, @Min(0) Long mongoId,
                                    LocalDateTime created, LocalDateTime modified) implements Serializable {
}