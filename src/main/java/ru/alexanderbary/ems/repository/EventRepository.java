package ru.alexanderbary.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexanderbary.ems.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
