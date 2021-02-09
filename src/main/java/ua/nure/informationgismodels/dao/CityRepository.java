package ua.nure.informationgismodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nure.informationgismodels.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
