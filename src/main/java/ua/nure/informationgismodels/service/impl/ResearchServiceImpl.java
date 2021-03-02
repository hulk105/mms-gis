package ua.nure.informationgismodels.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nure.informationgismodels.dao.GroupRepository;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.service.ResearchService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResearchServiceImpl implements ResearchService {

    private final GroupRepository groupRepository;

    @Override
    public Collection<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findById(long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group save(Group gis) {
        return groupRepository.save(gis);
    }

    @Override
    public Group update(Group gis) {
        return groupRepository.save(gis);
    }

    @Override
    public void deleteById(long gisId) {
        groupRepository.deleteById(gisId);
    }
}
