package com.ace.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    @NotBlank
    private String title;

    private String isbn;

    private Integer publishedYear;

    private Integer availableCopies;

    private Long categoryId;

    private List<Long> authorIds;
}
