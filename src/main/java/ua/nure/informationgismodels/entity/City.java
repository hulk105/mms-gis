package ua.nure.informationgismodels.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.nure.informationgismodels.entity.basic.BasicGis;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class City extends BasicGis {

    public City(long id, Point point, double absX, double absY, int radius, String tag) {
        super(id, point, absX, absY, radius, tag);
    }
}
