package ru.alexanderbary.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexanderbary.ems.model.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
}
