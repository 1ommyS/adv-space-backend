package adv.space.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tags")
public class TagEntity extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String title;

}