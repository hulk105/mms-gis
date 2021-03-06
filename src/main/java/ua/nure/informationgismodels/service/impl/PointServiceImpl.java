package ua.nure.informationgismodels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.informationgismodels.dao.GroupRepository;
import ua.nure.informationgismodels.dao.PointRepository;
import ua.nure.informationgismodels.dto.CreatePointDto;
import ua.nure.informationgismodels.dto.UpdatePointDto;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.entity.Point;
import ua.nure.informationgismodels.exception.NotFoundException;
import ua.nure.informationgismodels.service.PointService;
import ua.nure.informationgismodels.service.dto.PointDtoTransformationService;

import java.util.Collection;
import java.util.Optional;

@Service
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    private final PointDtoTransformationService pointDtoTransformationService;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository, PointDtoTransformationService pointDtoTransformationService) {
        this.pointRepository = pointRepository;
        this.pointDtoTransformationService = pointDtoTransformationService;
    }

    @Override
    public Optional<Point> findById(long id) {
        return pointRepository.findById(id);
    }

    @Override
    public Collection<Point> findBySection(Group.Section section) {
        return pointRepository.findBySection(section);
    }

    @Override
    public Point save(CreatePointDto dto) {
        Point point = pointDtoTransformationService.transformCreatePointDtoToPoint(dto);
        return pointRepository.save(point);
    }

    @Override
    public Point update(UpdatePointDto dto) {
        Point point = pointRepository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Can't find point by id"));
        point.setX(dto.getX());
        point.setY(dto.getY());
        return pointRepository.save(point);
    }

    @Override
    public void deleteById(long id) {
        pointRepository.deleteById(id);
    }
}
