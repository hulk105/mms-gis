package ua.nure.informationgismodels.service.dto;

import ua.nure.informationgismodels.dto.CreatePointDto;
import ua.nure.informationgismodels.entity.Point;

public interface PointDtoTransformationService {

    Point transformCreatePointDtoToPoint(CreatePointDto dto);
}
