package com.example.library.service;

import com.example.library.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);

    BookDTO getBookById(Long id);

    List<BookDTO> getAllBooks();

    BookDTO updateBook(BookDTO bookDTO);

    BookDTO deleteBook(BookDTO bookDTO);

}
