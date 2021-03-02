package ua.nure.informationgismodels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nure.informationgismodels.entity.Group;

import java.util.Collection;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Collection<Group> findBySection(Group.Section section);
}
