package com.ace.library.dto;

import com.ace.library.entity.LoanStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDto {

    @NotNull
    private Long bookId;

    @NotNull
    private Long memberId;

    private LocalDate loanDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private LoanStatus status;
}
