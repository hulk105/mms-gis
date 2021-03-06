package ua.nure.informationgismodels.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    private long id;

    @Size(max = 255, message = "Maximum allowed size is {max} symbols")
    private String tag;

    @Enumerated(EnumType.STRING)
    private Section section;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Point> points;

    public enum Section {
        RESEARCH, INFLUENCE, CITIES
    }
}
