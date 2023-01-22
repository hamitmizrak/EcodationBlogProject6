package com.hamitmizrak.annotation;

import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//lombok
@RequiredArgsConstructor
public class RegisterUniqueEmailValidation implements ConstraintValidator<RegisterUniqueEmail,String> {

    //inject
    private final IRegisterRepository iRegisterRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        RegisterEntity registerEntity=iRegisterRepository.findByEmail(email);
        //eğer böyle bir email varsa sistemde return false
        if(registerEntity!=null)
            return  false;
        return true;
    }
}
