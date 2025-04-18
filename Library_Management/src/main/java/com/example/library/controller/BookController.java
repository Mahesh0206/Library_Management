package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import com.example.library.util.CommonApiResponse;
import com.example.library.util.ResponseData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private CommonApiResponse commonApiResponse;

    @PostMapping("/save")
    public ResponseEntity<ResponseData> create(@RequestBody @Validated(BookDTO.BookSave.class) BookDTO bookDTO
    ,Errors errors){
        System.out.println("book: "+bookDTO);
        if (errors.hasErrors()){
            return commonApiResponse.errorResponse(errors);
        }
        return commonApiResponse.successResponse(service.createBook(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable @Validated(BookDTO.BookList.class) Long id) {
        return ResponseEntity.ok(service.getBookById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<BookDTO>> getAll() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @PutMapping("/update")
    public ResponseEntity<BookDTO> update( @RequestBody  @Validated(BookDTO.BookUpdate.class) BookDTO bookDTO) {
        return ResponseEntity.ok(service.updateBook(bookDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody  @Validated(BookDTO.BookDelete.class) BookDTO bookDTO) {
        service.deleteBook(bookDTO);
        return ResponseEntity.noContent().build();
    }
}
