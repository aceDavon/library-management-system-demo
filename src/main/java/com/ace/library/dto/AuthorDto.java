package com.ace.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String biography;
}
