package ru.alexanderbary.ems.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Location")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Location {

    public Location() {}

    public Location(Long id, String name, String city, String street, Integer houseNumber, List<Event> events) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.events = events;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Location's name should not be empty")
    @Size(min=2, max=50, message = "Location's name should be between 2 and 50 characters")
    private String name;

    @Column(name = "city")
    @NotEmpty(message = "City's name should not be empty")
    @Size(min=2, max=50, message = "City's name should be between 2 and 50 characters")
    private String city;

    @Column(name = "street")
    @NotEmpty(message = "Street's name should not be empty")
    @Size(min=2, max=50, message = "Street's name should be between 2 and 50 characters")
    private String street;

    @Column(name = "house_number")
    @NotNull(message = "House's number should not be empty")
    private Integer houseNumber;

    @OneToMany(mappedBy="location")
    @JsonIgnore
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
