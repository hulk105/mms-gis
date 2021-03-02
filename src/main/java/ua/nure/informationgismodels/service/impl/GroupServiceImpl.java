package ua.nure.informationgismodels.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.informationgismodels.dao.GroupRepository;
import ua.nure.informationgismodels.dao.PointRepository;
import ua.nure.informationgismodels.dto.UpdateGroupDto;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.exception.NotFoundException;
import ua.nure.informationgismodels.service.GroupService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final PointRepository pointRepository;

    @Override
    public Collection<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findById(long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Collection<Group> findBySection(Group.Section section) {
        return groupRepository.findBySection(section);
    }

    @Override
    public Group save(Group gis) {
        return groupRepository.save(gis);
    }

    @Override
    public Group update(UpdateGroupDto dto) {
        Group group = groupRepository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Can't find group with such id"));
        group.setTag(dto.getTag());
        group.setSection(dto.getSection());
        return groupRepository.save(group);
    }

    @Override
    @Transactional
    public void deleteById(long groupId) {
        Group group = findById(groupId)
                .orElseThrow(() -> new NotFoundException("Can't find group with such id"));
        pointRepository.deleteInBatch(group.getPoints());
        groupRepository.delete(group);
    }
}
