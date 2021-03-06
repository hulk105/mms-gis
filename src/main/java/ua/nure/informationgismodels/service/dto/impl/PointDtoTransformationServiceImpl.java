package ua.nure.informationgismodels.service.dto.impl;

import org.springframework.stereotype.Service;
import ua.nure.informationgismodels.dao.GroupRepository;
import ua.nure.informationgismodels.dto.CreatePointDto;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.entity.Point;
import ua.nure.informationgismodels.exception.NotFoundException;
import ua.nure.informationgismodels.service.dto.PointDtoTransformationService;

@Service
public class PointDtoTransformationServiceImpl implements PointDtoTransformationService {

    private final GroupRepository groupRepository;

    public PointDtoTransformationServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Point transformCreatePointDtoToPoint(CreatePointDto dto){
        Point point = new Point();
        Group group = groupRepository.findById(dto.getGroupId())
                .orElseThrow(() -> new NotFoundException("Can't find group by id"));;
        point.setGroup(group);
        point.setX(dto.getX());
        point.setY(dto.getY());
        return point;
    }
}
