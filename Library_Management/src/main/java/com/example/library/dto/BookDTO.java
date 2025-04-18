package com.example.library.dto;

import com.example.library.model.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BookDTO {

    @NotNull(message = "Book Id is mandatory", groups ={ BookUpdate.class,BookDelete.class,BookList.class})
    private Long id;
    @NotBlank(message = "Title is Mandatory",groups = {BookSave.class})
    private String title;

    @NotBlank(message = "Author cannot be blank",groups = {BookSave.class})
    private String author;

    @NotNull(message = "Publication year is required",groups = {BookSave.class})
    @Min(value = 1000, message = "Publication year must be valid")
    private Integer publicationYear;

    public interface BookSave{}
    public interface BookList{}
    public interface BookUpdate{}
    public interface BookDelete{}

}
