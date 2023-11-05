package adv.space.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class CompanyEntity extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column()
    @NotBlank
    private String iconUrl;

    @OneToOne
    @JoinColumn(name = "delegate_id")
    private UserEntity delegate;

}