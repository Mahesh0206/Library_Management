package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.service.BookService;
import com.example.library.util.CommonApiResponse;
import com.example.library.util.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private CommonApiResponse commonApiResponse;

    @PostMapping("/save")
    public ResponseEntity<ResponseData> create(@RequestBody @Validated(BookDTO.BookSave.class) BookDTO bookDTO, Errors errors) {
        System.out.println("book: " + bookDTO);
        if (errors.hasErrors()) {
            return commonApiResponse.errorResponse(errors);
        }
        return commonApiResponse.successResponse(service.createBook(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData> getById(@PathVariable @Validated(BookDTO.BookList.class) Long id) {
        return commonApiResponse.successResponse(service.getBookById(id));

    }

    @GetMapping("getAll")
    public ResponseEntity<ResponseData> getAll() {
        return commonApiResponse.successResponse(service.getAllBooks());
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData> update(@RequestBody @Validated(BookDTO.BookUpdate.class) BookDTO bookDTO, Errors errors) {
        if (errors.hasErrors()) {
            return commonApiResponse.errorResponse(errors);
        }
        return commonApiResponse.successResponse(service.updateBook(bookDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseData> delete(@RequestBody @Validated(BookDTO.BookDelete.class) BookDTO bookDTO, Errors errors) {
        if (errors.hasErrors()) {
            return commonApiResponse.errorResponse(errors);
        }
        BookDTO deletedBook = service.deleteBook(bookDTO);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("id", deletedBook.getId());
        responseMap.put("title", deletedBook.getTitle());
        responseMap.put("message", "Book deleted successfully");

        return commonApiResponse.successResponse(responseMap);
    }
}
