package ua.nure.informationgismodels.service;

import ua.nure.informationgismodels.dto.UpdateGroupDto;
import ua.nure.informationgismodels.entity.Group;

import java.util.Collection;
import java.util.Optional;

public interface GroupService {
    /**
     * Find all Group objects with section RESEARCH into DB
     * @return all {@link Group} objects with section RESEARCH
     */
    Collection<Group> findAll();
    /**
     * Find Group by its ID
     * @param id ID of requested object
     * @return {@link Optional} containing Group object or empty if not found
     */
    Optional<Group> findById(long id);
    /**
     * Find Group by its section
     * @param section section of requested object
     * @return {@link Optional} containing Group object or empty if not found
     */
    Collection<Group> findBySection(Group.Section section);
    /**
     * Save new valid Group object
     * @param group new object to save
     * @return saved object with its ID
     */
    Group save(Group group);
    /**
     * Update existed Group object
     * @param group object to update
     * @return update object from DB
     */
    Group update(UpdateGroupDto dto);
    /**
     * Remove Group by its ID
     * @param id ID of object to remove
     */
    void deleteById(long id);
}
