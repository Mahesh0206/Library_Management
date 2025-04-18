package com.example.library.serviceImpl;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import com.example.library.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        try{
        Book book  = objectMapper.convertValue(bookDTO, Book.class);
        Book save = bookRepository.save(book);
        bookDTO.setId(save.getId());
        return bookDTO;
        } catch(Exception e) {
            throw new RuntimeException("Getting error while saving the data");
        }
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id " + id));
       return objectMapper.convertValue(book,BookDTO.class);
    }

    @Override
    public List<BookDTO> getAllBooks() {


        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(bookObj -> objectMapper.convertValue(bookObj, BookDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Book existing = bookRepository.findById(bookDTO.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id " + bookDTO));
        Book book = objectMapper.convertValue(bookDTO, Book.class);
        Book updatedBook=null;
        if (existing!=null) {
            updatedBook= bookRepository.save(updatedBook);
        }
        return bookDTO;
    }

    @Override
    public void deleteBook(BookDTO bookDTO) {
        bookRepository.deleteById(bookDTO.getId());
    }
}
