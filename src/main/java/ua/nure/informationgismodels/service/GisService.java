package ua.nure.informationgismodels.service;

import ua.nure.informationgismodels.entity.Gis;

import java.util.Collection;
import java.util.Optional;

public interface GisService {
    /**
     * Find all GIS objects into DB
     * @return all {@link Gis} objects
     */
    Collection<Gis> findAll();
    /**
     * Find Gis by its ID
     * @param id ID of requested object
     * @return {@link Optional} containing Gis object or empty if not found
     */
    Optional<Gis> findById(long id);
    /**
     * Save new valid GIS object
     * @param gis new object to save
     * @return saved object with its ID
     */
    Gis save(Gis gis);
    /**
     * Update existed GIS object
     * @param gis object to update
     * @return update object from DB
     */
    Gis update(Gis gis);
    /**
     * Remove GIS by its ID
     * @param gisId ID of object to remove
     */
    void removeById(long gisId);
}
