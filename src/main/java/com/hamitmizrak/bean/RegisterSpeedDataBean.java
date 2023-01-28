package com.hamitmizrak.bean;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletContext;
import java.util.UUID;

//Lombok
@RequiredArgsConstructor  //Lombok Injection 2.YOL

@Configuration
public class RegisterSpeedDataBean {

    //messages.properties
    @Value("${user.surname}")
    private String messagesPropertiesKey;

    //application.properties ==> veri almak
    //@Autowired 3.YOL (Field Injection )
    private final ServletContext servletContext;
    //  1.YOL (Constructor Injection )
    /*@Autowired
    public RegisterSpeedDataBean(ServletContext servletContext) {
        this.servletContext = servletContext;
    }*/

    // +++++++++++++++++++++++++++++++++++++++++++++++++++
    //Password Injection
    private final PasswordEncoderBean passwordEncoderBean;

    //Repository
    private final IRegisterRepository iRegisterRepository;

    //ModelMapper
    private final ModelMapperBean modelMapperBean;

    // +++++++++++++++++++++++++++++++++++++++++++++++++++

    //Bu proje ne zaman ayağa kalkarsa otomatik 5 tane hazır data ekle
    @Bean
    CommandLineRunner createRegister(){
        String applicationPropertiesUsername=servletContext.getInitParameter("my_special.name");
        //Lambda Expression
        return (args)->{
            for (int i = 1; i <=5 ; i++) {
                RegisterDto registerDto= RegisterDto.builder()
                        .username(applicationPropertiesUsername.concat(" "+i))
                        .surname(messagesPropertiesKey.concat(hashCode()+" "))
                        .password(passwordEncoderBean.passwordEncoderMethod().encode("root"))
                        .email(UUID.randomUUID().toString().concat("@gmail.com"))
                        .telephoneNumber("123 456 7890")
                        .build();
                RegisterEntity registerEntity=modelMapperBean.modelMapperMethod().map(registerDto,RegisterEntity.class);
                iRegisterRepository.save(registerEntity);
            }
        };
    }
}
