package com.example.library.service;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);

    BookDTO getBookById(Long id);

    List<BookDTO> getAllBooks();

    BookDTO updateBook(BookDTO bookDTO);

    void deleteBook(BookDTO bookDTO);
}
