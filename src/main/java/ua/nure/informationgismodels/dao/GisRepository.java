package ua.nure.informationgismodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nure.informationgismodels.entity.Gis;

@Repository
public interface GisRepository extends JpaRepository<Gis, Long> {
}
