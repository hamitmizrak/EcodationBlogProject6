package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import com.hamitmizrak.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//Lombok
@RequiredArgsConstructor //injection
@Log4j2
//@SneakyThrows

//Service: Asıl iş yükünü omuzlayan yapıdır.
@Service //stereotype
public class RegisterServiceImpl implements IRegisterService {

    //Injection  Lombok
    private final IRegisterRepository iRegisterRepository;
    private final ModelMapperBean modelMapperBean;
    private final PasswordEncoderBean passwordEncoderBean;

    //MODEL MAPPER
    @Override
    public RegisterDto EntityToDto(RegisterEntity registerEntity) {
        return modelMapperBean.modelMapperMethod().map(registerEntity, RegisterDto.class);
    }

    @Override
    public RegisterEntity DtoToEntity(RegisterDto registerDto) {
        return modelMapperBean.modelMapperMethod().map(registerDto, RegisterEntity.class);
    }

    //CREATE
    @Override
    public RegisterDto registerCreate(RegisterDto registerDto) {
        //Spring Security will masking
        registerDto.setPassword(passwordEncoderBean.passwordEncoderMethod().encode(registerDto.getPassword()));
        RegisterEntity registerEntity = iRegisterRepository.save(DtoToEntity(registerDto));
        registerDto.setId(registerEntity.getId());
        return registerDto;
    }

    //LIST
    @Override
    public List<RegisterDto> registerList() {
        //RegsiterDto List
        List<RegisterDto> registerDtoList = new ArrayList<>();
        //database verileri almak
        List<RegisterEntity> registerEntityList = iRegisterRepository.findAll();
        for (RegisterEntity entity:registerEntityList) {
            RegisterDto dto=    EntityToDto(entity);
            registerDtoList.add(dto);
        }
        return registerDtoList;
    }

    //FIND
    @Override
    public RegisterDto registerFind(Long id) {
        //1.YOL (Java 8 Optional)
        /*Optional<RegisterEntity> findById= iRegisterRepository.findById(id);
        RegisterDto registerDto= EntityToDto(findById.get());
        //eğer veri varsa dönder
        if(findById.isPresent()){
            return registerDto;
        }
         return null;
        */

        //2.YOL
        RegisterEntity findById = iRegisterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+" nolu id bulunamadı"));
        RegisterDto dto=    EntityToDto(findById);
        return dto;
    }

    //UPDATE
    @Override
    public RegisterDto registerUpdate(Long id, RegisterDto registerDto) {
        return null;
    }

    //DELETE
    @Override
    public Map<String, Boolean> RegisterDelete(Long id) {
        return null;
    }
}
