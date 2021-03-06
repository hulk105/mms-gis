package ua.nure.informationgismodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.entity.Point;

import java.util.Collection;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    @Query("SELECT p FROM Point p WHERE p.group.section = :#{#section}")
    Collection<Point> findBySection(@Param("section") Group.Section section);
}
