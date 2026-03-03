package com.ace.library.service;

import com.ace.library.dto.BookDto;
import com.ace.library.entity.Author;
import com.ace.library.entity.Book;
import com.ace.library.entity.Category;
import com.ace.library.exception.ResourceNotFoundException;
import com.ace.library.repository.AuthorRepository;
import com.ace.library.repository.BookRepository;
import com.ace.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book createBook(BookDto dto) {
        Book book = buildBookFromDto(new Book(), dto);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookDto dto) {
        Book book = getBookById(id);
        buildBookFromDto(book, dto);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        getBookById(id);
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> getBooksByCategory(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }

    private Book buildBookFromDto(Book book, BookDto dto) {
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setPublishedYear(dto.getPublishedYear());
        book.setAvailableCopies(dto.getAvailableCopies() != null ? dto.getAvailableCopies() : 1);

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.getCategoryId()));
            book.setCategory(category);
        }

        if (dto.getAuthorIds() != null && !dto.getAuthorIds().isEmpty()) {
            List<Author> authors = new ArrayList<>();
            for (Long authorId : dto.getAuthorIds()) {
                Author author = authorRepository.findById(authorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
                authors.add(author);
            }
            book.setAuthors(authors);
        }

        return book;
    }
}
