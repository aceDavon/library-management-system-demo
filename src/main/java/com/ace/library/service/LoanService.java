package com.ace.library.service;

import com.ace.library.dto.LoanDto;
import com.ace.library.entity.Book;
import com.ace.library.entity.Loan;
import com.ace.library.entity.LoanStatus;
import com.ace.library.entity.Member;
import com.ace.library.exception.ResourceNotFoundException;
import com.ace.library.repository.BookRepository;
import com.ace.library.repository.LoanRepository;
import com.ace.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public Loan issueLoan(LoanDto dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + dto.getBookId()));
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + dto.getMemberId()));

        if (book.getAvailableCopies() <= 0) {
            throw new IllegalStateException("No available copies for book with id: " + dto.getBookId());
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        Loan loan = Loan.builder()
                .book(book)
                .member(member)
                .loanDate(dto.getLoanDate() != null ? dto.getLoanDate() : LocalDate.now())
                .dueDate(dto.getDueDate() != null ? dto.getDueDate() : LocalDate.now().plusDays(14))
                .status(LoanStatus.ACTIVE)
                .build();

        return loanRepository.save(loan);
    }

    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + loanId));

        loan.setReturnDate(LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);

        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }

    public List<Loan> getOverdueLoans() {
        // Finds active loans past their due date, marks them OVERDUE, and returns them
        List<Loan> overdueLoans = loanRepository.findByDueDateBeforeAndStatus(LocalDate.now(), LoanStatus.ACTIVE);
        overdueLoans.forEach(loan -> loan.setStatus(LoanStatus.OVERDUE));
        loanRepository.saveAll(overdueLoans);
        return overdueLoans;
    }

    public List<Loan> getLoansByMember(Long memberId) {
        return loanRepository.findByMemberId(memberId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));
    }
}
