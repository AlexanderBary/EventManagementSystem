package ru.alexanderbary.ems.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@Builder
@AllArgsConstructor
public class Community {

    @Id
    private Long id;

    @NotEmpty(message = "Community's name name should not be empty")
    @Size(min=2, max=50, message = "Community's name should be between 2 and 50 characters")
    private String name;


}
