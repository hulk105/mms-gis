package ua.nure.informationgismodels.service;

import ua.nure.informationgismodels.dto.CreatePointDto;
import ua.nure.informationgismodels.dto.UpdatePointDto;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.entity.Point;

import java.util.Collection;
import java.util.Optional;

public interface PointService {
    /**
     * Find Point by its ID
     *
     * @param id ID of requested object
     * @return {@link Optional} containing Group object or empty if not found
     */
    Optional<Point> findById(long id);

    /**
     * Find Point by its group section
     *
     * @param section section of group
     * @return {@link Collection} containing Point object or empty if not found
     */
    Collection<Point> findBySection(Group.Section section);

    /**
     * Save new valid Point object
     *
     * @param dto data to save new object
     * @return saved object with its ID
     */
    Point save(CreatePointDto dto);

    /**
     * Update existed Point object
     *
     * @param dto data for update
     * @return updated object from DB
     */
    Point update(UpdatePointDto dto);

    /**
     * Remove Point by its ID
     *
     * @param id ID of object to remove
     */
    void deleteById(long id);
}
