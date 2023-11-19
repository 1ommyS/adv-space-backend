package adv.space.entity;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.*;

/**
 * @author 1ommy
 * @version 16.11.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "bargain")
public class BargainEntity extends BaseAuditEntity<Long> {
    @OneToOne
    private AdvertisementEntity advertisement;

    @OneToOne
    private UserEntity advertiser;

    @OneToOne
    private UserEntity customer;

    @Min(0)
    private Double price;

    @Min(0)
    private Long mongoId;

    private boolean deleted = Boolean.FALSE;
    public void softDelete() {
        this.deleted = true;
    }
}
