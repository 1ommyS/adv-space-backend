package adv.space.entity;


import adv.space.enums.TypeOfAdvertisement;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.catalina.User;

import java.util.List;


@Table(name = "advertisements")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdvertisementEntity extends BaseAuditEntity<Long> {
    @Column(name = "title", nullable = false)
    @NotBlank
    private String title;

    @Column(name = "content", nullable = false)
    @NotBlank
    private String content;

    @Column(name = "price", nullable = false)
    @Min(0)
    private int price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToMany
    @JoinTable(
            name = "advertisement_tag",
            joinColumns = @JoinColumn(name = "advertisement_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @ToString.Exclude
    private List<TagEntity> tags;

    @ManyToOne(optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity area;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeOfAdvertisement type;


}