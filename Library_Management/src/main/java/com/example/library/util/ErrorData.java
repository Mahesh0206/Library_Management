package com.example.library.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorData implements Serializable {
    private static final long serialVersionUID = 1L;
    String field;
    String errorMessage;
}
