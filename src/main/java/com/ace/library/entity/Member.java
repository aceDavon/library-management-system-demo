package com.ace.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private LocalDate membershipDate;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loans;
}
