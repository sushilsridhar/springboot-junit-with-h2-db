package service;

import dto.AccountDto;
import entity.Account;
import entity.AccountCompositeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

import java.util.Optional;

@Service
@Slf4j
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void updateAccountDetails(AccountDto accountDto) {

        final Long userId = accountDto.getUserId();
        final String accountNumber = accountDto.getAccountNumber();

        AccountCompositeKey accountCompositeKey = AccountCompositeKey.builder()
                .userId(userId).accountNumber(accountNumber).build();

        Optional<Account> optionalAccount = accountRepository.findById(accountCompositeKey);

        if(optionalAccount.isPresent()) {
            log.info("Account is present");
            Account account = optionalAccount.get();

            if(account.getIsAccountActive()) {
                log.info("Account is active");
                account.setIsDebitCardActive(accountDto.getIsDebitCardActive());
            }

        } else {
            AccountCompositeKey newAccountCompositeKey = AccountCompositeKey.builder()
                    .userId(userId).accountNumber(accountNumber).build();

            Account newAccount = new Account();

            newAccount.setAccountCompositeKey(newAccountCompositeKey);
            newAccount.setFirstName(accountDto.getFirstName());
            newAccount.setLastName(accountDto.getLastName());
            newAccount.setIfscCode(accountDto.getIfscCode());
            newAccount.setIsAccountActive(accountDto.getIsAccountActive());
            newAccount.setIsDebitCardActive(accountDto.getIsDebitCardActive());

            log.info("Save new account");
            accountRepository.save(newAccount);
        }
    }
}
