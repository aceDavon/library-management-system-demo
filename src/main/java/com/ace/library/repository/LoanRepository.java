package com.ace.library.repository;

import com.ace.library.entity.Loan;
import com.ace.library.entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByMemberId(Long memberId);

    List<Loan> findByStatus(LoanStatus status);

    List<Loan> findByDueDateBeforeAndStatus(LocalDate date, LoanStatus status);
}
