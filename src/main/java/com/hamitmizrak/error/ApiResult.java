package com.hamitmizrak.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.Map;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
//@SneakyThrows

//Backentte Frontendte giderken bilgilerden null olanları göstermek
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    //SEMPT VAL-
    private int status;
    private String error;
    private String message;
    private String path;
    private Date date=new Date(System.currentTimeMillis());

    //ValidationError: birden fazla hata yakalamak için kullanıyoruz
    private Map<String,String> validationErrors;

    //parametreli constructor
    public ApiResult(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    //Overloading => parametreli constructor
    public ApiResult(int status,  String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
