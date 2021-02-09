package ua.nure.informationgismodels.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nure.informationgismodels.dao.GisRepository;
import ua.nure.informationgismodels.entity.Gis;
import ua.nure.informationgismodels.service.GisService;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GisServiceImpl implements GisService {

    private final GisRepository gisRepository;

    @Override
    public Collection<Gis> findAll() {
        return gisRepository.findAll();
    }

    @Override
    public Optional<Gis> findById(long id) {
        return gisRepository.findById(id);
    }

    @Override
    public Gis save(Gis gis) {
        return gisRepository.save(gis);
    }

    @Override
    public Gis update(Gis gis) {
        return gisRepository.save(gis);
    }

    @Override
    public void removeById(long gisId) {
        gisRepository.deleteById(gisId);
    }
}
