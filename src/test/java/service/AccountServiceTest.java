package service;

import dto.AccountDto;
import entity.Account;
import entity.AccountCompositeKey;
import mapper.AccountMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.AccountRepository;
import utils.EnableH2Database;

import java.util.Optional;


@EnableH2Database
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AccountService.class, AccountMapperImpl.class })
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("test account service")
    public void testAccountService() {

        AccountDto accountDto = AccountDto.builder().userId(101L).accountNumber("123456")
                .firstName("John").lastName("Wick").ifscCode("8989")
                .isAccountActive(true).isDebitCardActive(true)
                .build();

        accountService.updateAccountDetails(accountDto);

        AccountCompositeKey accountCompositeKey = AccountCompositeKey.builder()
                .userId(101L)
                .accountNumber("123456")
                .build();

        final Optional<Account> accountOptionalAfterProcessing = accountRepository.findById(accountCompositeKey);
        Assertions.assertTrue(accountOptionalAfterProcessing.isPresent(), "Account should be present");

        Account accountAfterProcessing = accountOptionalAfterProcessing.orElse(new Account());

        Assertions.assertEquals(101L, accountAfterProcessing.getAccountCompositeKey().getUserId(), "User Id should match. ");
        Assertions.assertEquals("123456", accountAfterProcessing.getAccountCompositeKey().getAccountNumber(), "Account number should match. ");
        Assertions.assertEquals("John", accountAfterProcessing.getFirstName(), "First name should match. ");
        Assertions.assertEquals("Wick", accountAfterProcessing.getLastName(), "Last name should match. ");
        Assertions.assertTrue(accountAfterProcessing.getIsDebitCardActive(), "Debit card should be active. ");
        Assertions.assertTrue(accountAfterProcessing.getIsAccountActive(), "Account should be active. ");

    }
}
