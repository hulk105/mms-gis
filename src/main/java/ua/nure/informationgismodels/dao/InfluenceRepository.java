package ua.nure.informationgismodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nure.informationgismodels.entity.Influence;

@Repository
public interface InfluenceRepository extends JpaRepository<Influence, Long> {
}
