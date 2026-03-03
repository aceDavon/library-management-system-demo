package com.ace.library.service;

import com.ace.library.dto.AuthorDto;
import com.ace.library.entity.Author;
import com.ace.library.exception.ResourceNotFoundException;
import com.ace.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    public Author createAuthor(AuthorDto dto) {
        Author author = Author.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .biography(dto.getBiography())
                .build();
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, AuthorDto dto) {
        Author author = getAuthorById(id);
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setBiography(dto.getBiography());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        getAuthorById(id);
        authorRepository.deleteById(id);
    }
}
