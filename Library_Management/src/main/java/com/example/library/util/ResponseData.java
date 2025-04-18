package com.example.library.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer statusCode;
    private String statusMessage;
    private Object data;
    private List<ErrorData> errors;

}
