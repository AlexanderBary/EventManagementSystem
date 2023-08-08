package ru.alexanderbary.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "event")
public class Event {

    public Event() {}

    public Event(String name, String description, Integer capacity, Community owner, List<Category> categories, List<Customer> customers, Location location) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.owner = owner;
        this.categories = categories;
        this.customers = customers;
        this.location = location;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Event's name should not be empty")
    @Size(min=2, max=50, message = "Event's name  should be between 2 and 50 characters")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    @Min(value=0, message = "Event's capacity should be more than 0")
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community owner;


    @ManyToMany(mappedBy = "events") // будет ли работать корректно
    private List<Category> categories;

    @ManyToMany(mappedBy = "events") // будет ли работать корректно
    private List<Customer> customers;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Community getOwner() {
        return owner;
    }

    public void setOwner(Community owner) {
        this.owner = owner;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
