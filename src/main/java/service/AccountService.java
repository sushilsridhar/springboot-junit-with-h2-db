package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void updateAccountDetails(Long userId, String accountNumber) {

        //find by id, use embedded id
        //  if already present update, else create new record
        // use mapstruct lombok , feature flag with @EnableCOnfigurationProperties
        // custom annotation

        //String a = accountRepository.findById();


    }
}
