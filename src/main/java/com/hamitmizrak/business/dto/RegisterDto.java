package com.hamitmizrak.business.dto;

import com.hamitmizrak.annotation.RegisterUniqueEmail;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @NotNull(message = "{register.username.validation.constraints.NotNull.message}")
    private String username;

    @NotNull(message = "{register.surname.validation.constraints.NotNull.message}")
    private String surname;

    @NotNull(message = "{register.email.validation.constraints.NotNull.message}")
    @Email(message = "{register.email.validation.constraints.property.message}")
    @Size(max = 150,message = "{register.email.validation.constraints.max.message}")
    @RegisterUniqueEmail
    private String email;

    @NotNull(message = "{register.password.validation.constraints.NotNull.message}")
    @Pattern(regexp = "",message = "{register.password.validation.constraints.pattern.regex.message}")
    private String password;

    @NotNull(message = "{register.telephone.validation.constraints.NotNull.message}")
    @Pattern(regexp = "",message = "{register.telephone.validation.constraints.pattern.regex.message}")
    private String telephoneNumber;

    private Date createdDate;
}
