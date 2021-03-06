package ua.nure.informationgismodels.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePointDto {

    private double x;

    private double y;

    private long groupId;
}
