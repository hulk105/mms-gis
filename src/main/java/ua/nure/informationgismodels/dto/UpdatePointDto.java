package ua.nure.informationgismodels.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatePointDto {

    private long id;

    private double x;

    private double y;
}
