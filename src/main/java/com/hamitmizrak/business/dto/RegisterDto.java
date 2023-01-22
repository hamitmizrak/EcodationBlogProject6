package com.hamitmizrak.business.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
//@SneakyThrows

public class RegisterDto {

    private Long id;
    @NotNull(message = "{}")
    @Size
    private String username;
    private String surname;
    private String email;
    private String password;
    private Date createdDate;
}
