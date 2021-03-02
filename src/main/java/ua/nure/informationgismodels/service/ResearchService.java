package ua.nure.informationgismodels.service;

import ua.nure.informationgismodels.entity.Group;

import java.util.Collection;
import java.util.Optional;

public interface ResearchService {
    /**
     * Find all Group objects with section RESEARCH into DB
     * @return all {@link Group} objects with section RESEARCH
     */
    Collection<Group> findAll();
    /**
     * Find Gis by its ID
     * @param id ID of requested object
     * @return {@link Optional} containing Gis object or empty if not found
     */
    Optional<Group> findById(long id);
    /**
     * Save new valid GIS object
     * @param gis new object to save
     * @return saved object with its ID
     */
    Group save(Group gis);
    /**
     * Update existed GIS object
     * @param gis object to update
     * @return update object from DB
     */
    Group update(Group gis);
    /**
     * Remove GIS by its ID
     * @param id ID of object to remove
     */
    void deleteById(long id);
}
