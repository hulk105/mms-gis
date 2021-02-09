package ua.nure.informationgismodels.entity.basic;

import lombok.*;
import ua.nure.informationgismodels.entity.Point;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class BasicGis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    private long id;
    @Embedded
    private @Valid Point point;
    private double absX;
    private double absY;
    @PositiveOrZero
    private int radius;
    @Size(max = 255, message = "Maximum allowed size is {max} symbols")
    private String tag;
}
