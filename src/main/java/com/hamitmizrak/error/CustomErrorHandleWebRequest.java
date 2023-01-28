package com.hamitmizrak.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor
@Log4j2


//API
@RestController
@CrossOrigin
public class CustomErrorHandleWebRequest implements ErrorController {

    //Injection
    private final ErrorAttributes errorAttributes;

    //http://localhost:4444/error
    @RequestMapping("/error")
    ApiResult handleError(WebRequest webRequest){
        // SEMPT VAL-
        Map<String,Object> attributes=errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS));
        int status=(Integer)attributes.get("status");
        String message=(String)attributes.get("message");
        String path=(String)attributes.get("path");
        ApiResult error=new ApiResult(status,message,path);

        if(attributes.containsKey("errors")){
            List<FieldError> fieldErrors=( List<FieldError>)attributes.get("errors");
            Map<String,String> validationMistake=new HashMap<>();
            for (FieldError fieldError: fieldErrors) {
                validationMistake.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            error.setValidationErrors(validationMistake);
        }
        return error;
    }
}
