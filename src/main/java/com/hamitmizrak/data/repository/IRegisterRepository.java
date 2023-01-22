package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring 2.2. then @Repository yazmak zorunda değiliz. ama bizler yazalım
@Repository
public interface IRegisterRepository extends JpaRepository<RegisterEntity,Long> {

    //Delivered Query
    RegisterEntity findByEmail(String email);
}
