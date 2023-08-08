package ru.alexanderbary.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
@Table(name = "Community")
public class Community {

    public Community() {
    }

    public Community(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "community_name")
    @NotEmpty(message = "Community's name name should not be empty")
    @Size(min=2, max=50, message = "Community's name should be between 2 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Event> events;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
