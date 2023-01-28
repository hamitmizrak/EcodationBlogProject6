package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor //injection
@Log4j2

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
        return modelMapperBean.modelMapperMethod().map(registerEntity,RegisterDto.class);
    }

    @Override
    public RegisterEntity DtoToEntity(RegisterDto registerDto) {
        return modelMapperBean.modelMapperMethod().map(registerDto,RegisterEntity.class);
    }

    //CREATE
    @Override
    public RegisterDto registerCreate(RegisterDto registerDto) {
        return null;
    }

    //LIST
    @Override
    public List<RegisterDto> registerList() {
        return null;
    }

    //FIND
    @Override
    public RegisterDto registerFind(Long id) {
        return null;
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
