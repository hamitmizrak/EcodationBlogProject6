package com.hamitmizrak.controller.api;

import com.hamitmizrak.business.dto.RegisterDto;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IRegisterApi {
    // Profile
    String getProfileRegister(String name);

    // Header Information
    void getHeaderInformationRegister(Map<String,String> headers);

    // App Information
    ResponseEntity<?> getAppInformationRegister(HttpServletRequest request, HttpServletResponse response);

    ///////// CRUD
    //CREATE
    ResponseEntity<?> apiRegisterCreate(RegisterDto registerDto);

    //LIST
    ResponseEntity<List<RegisterDto>> apiRegisterList();

    //FIND
    ResponseEntity<?> apiRegisterFind(Long id);

    //UPDATE
    ResponseEntity<RegisterDto> apiRegisterUpdate(Long id, RegisterDto registerDto);

    //DELETE
    ResponseEntity<Map<String,Boolean>> apiRegisterDelete(Long id);
}
