package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.controller.api.IRegisterApi;
import com.hamitmizrak.error.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor //injection
@Log4j2

//Dış dünyaya açılan kapıdır
@RestController
@RequestMapping("register")
@CrossOrigin(origins = "http://localhost:3000") //CORS
public class RegisterApiImpl implements IRegisterApi {

    //injection
    private final IRegisterService iRegisterService;

    @Override
    public String getProfileRegister(String name) {
        return null;
    }

    @Override
    public void getHeaderInformationRegister(Map<String, String> headers) {

    }

    @Override
    public ResponseEntity<?> getAppInformationRegister(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    // CREATE
    /// http://localhost:4444/register/create
    @Override
    @PostMapping("create")
    public ResponseEntity<?> apiRegisterCreate(@Valid @RequestBody RegisterDto registerDto) {
        iRegisterService.registerCreate(registerDto);
        return ResponseEntity.ok(registerDto);
    }

    //LIST
    //http://localhost:4444/register/list
    @Override
    @GetMapping(value="/list")
    public ResponseEntity<List<RegisterDto>> apiRegisterList() {
        return ResponseEntity.ok(iRegisterService.registerList());
    }

    //FIND
    //http://localhost:4444/register
    //http://localhost:4444/register/0
    //http://localhost:4444/register/1
    @Override
    @GetMapping({"","/{id}"})
    public ResponseEntity<?> apiRegisterFind(@PathVariable (name="id",required = false) Long id) {
        if(id==null){
            log.error("404 Not Found");
            return ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 Bad Request");
            return ResponseEntity.badRequest().body("Kötü istek");
        }else if(id<-2){
            log.error("400 Bad Request");
            ApiResult apiResult= ApiResult.builder()
                    .path("/register/")
                    .message("bad request 44")
                    .status(400).build();
            return ResponseEntity.status(400).body(apiResult);
        }else if(id==-1){
            log.error("401 unAuthorized");
            ApiResult apiResult= ApiResult.builder()
                    .path("/register/")
                    .message("unAuthorized")
                    .status(401).build();
            return ResponseEntity.status(401).body(apiResult);
        }
        log.info("Veriler: "+iRegisterService.registerFind(id));
        return ResponseEntity.ok(iRegisterService.registerFind(id));
    }

    //PUT
    //http://localhost:4444/register
    //http://localhost:4444/register/1
    @Override
    @PutMapping({"","/{id}"})
    public ResponseEntity<RegisterDto> apiRegisterUpdate(
            @PathVariable (name="id",required = false) Long id,
            @Valid @RequestBody RegisterDto registerDto) {
        if(id==null){
            log.error("404 Not Found");
            return ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 Bad Request");
            return ResponseEntity.badRequest().build();
        }
        log.info("Veriler: "+iRegisterService.registerUpdate(id,registerDto));
        return ResponseEntity.ok(iRegisterService.registerUpdate(id,registerDto));
    }

    //DELETE
    //http://localhost:4444/register
    //http://localhost:4444/register/0
    //http://localhost:4444/register/1
    @Override
    @DeleteMapping({"","/{id}"})
    public ResponseEntity<Map<String, Boolean>> apiRegisterDelete(@PathVariable (name="id",required = false) Long id) {
        if(id==null){
            log.error("404 Not Found");
            return ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 Bad Request");
            return ResponseEntity.badRequest().build();
        }
        log.info("Veriler: "+iRegisterService.registerFind(id));
        iRegisterService.registerDelete(id);
        Map<String,Boolean> response=new LinkedHashMap<>();
            response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
