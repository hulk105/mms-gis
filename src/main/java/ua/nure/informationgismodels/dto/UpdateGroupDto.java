package ua.nure.informationgismodels.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.nure.informationgismodels.entity.Group;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UpdateGroupDto {

    @PositiveOrZero
    long id;

    @Size(max = 255, message = "Maximum allowed size is {max} symbols")
    String tag;

    @NotNull
    Group.Section section;
}
