package ru.alexanderbary.ems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private Long event_id;
    private String event_name;
    private String description;
    private Date startDate;
    private Integer capacity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Community company;
}
