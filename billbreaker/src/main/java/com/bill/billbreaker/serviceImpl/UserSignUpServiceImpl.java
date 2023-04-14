package com.bill.billbreaker.serviceImpl;

import com.bill.billbreaker.dao.UserSignUpDB;
import com.bill.billbreaker.dao.UserUniqueKey;
import com.bill.billbreaker.repository.UserSignUpRepository;
import com.bill.billbreaker.service.UserSignUpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UserSignUpServiceImpl implements UserSignUpService {

    @Autowired
    private UserSignUpRepository userSignUpRepository;


    @Override
    public String UserSigning(UserSignUpDB userSignUpDB) {
        Optional<UserSignUpDB> value = userSignUpRepository.findById(userSignUpDB.getUserUniqueKey());
        log.info("Started registering in DB");
        if(value.isPresent()){
            return "Email and Mobile Number already used";
        }
        else {
            userSignUpRepository.save(userSignUpDB);
            return "SignedUp successfully";

        }
    }
}
