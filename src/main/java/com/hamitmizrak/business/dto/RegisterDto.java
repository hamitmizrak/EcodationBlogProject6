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
    @Size(max = 150, message = "{register.email.validation.constraints.max.message}")
    @RegisterUniqueEmail
    private String email;

    @NotNull(message = "{register.password.validation.constraints.NotNull.message}")
    // en az 1 sayı, 1 küçük harf, 1 büyük harf 1 tane özel karakter
    /*
    123-456-7890
    (123) 456-7890
    123 456 7890
    123.456.7890
    +91 (123) 456-7890
    */
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$", message = "{register.password.validation.constraints.pattern.regex.message}")
    private String password;

    @NotNull(message = "{register.telephone.validation.constraints.NotNull.message}")
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "{register.telephone.validation.constraints.pattern.regex.message}")
    private String telephoneNumber;

    private Date createdDate;
}
