package com.example.demo.ContollerExample;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    private String email;

}

