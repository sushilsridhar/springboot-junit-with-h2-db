package service;

import dto.AccountDto;
import entity.Account;
import entity.AccountCompositeKey;
import mapper.AccountMapper;
import mapper.AccountMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.AccountRepository;
import utils.EnableH2Database;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@EnableH2Database
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AccountService.class, AccountMapperImpl.class })
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @SpyBean
    private AccountMapper accountMapper;

    @Test
    @DisplayName("test account service - debit card update")
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

        verify(accountMapper, never()).convertDtoToEntity(any());
        Assertions.assertEquals(101L, accountAfterProcessing.getAccountCompositeKey().getUserId(), "User Id should match. ");
        Assertions.assertEquals("123456", accountAfterProcessing.getAccountCompositeKey().getAccountNumber(), "Account number should match. ");
        Assertions.assertEquals("John", accountAfterProcessing.getFirstName(), "First name should match. ");
        Assertions.assertEquals("Wick", accountAfterProcessing.getLastName(), "Last name should match. ");
        Assertions.assertTrue(accountAfterProcessing.getIsDebitCardActive(), "Debit card should be active. ");
        Assertions.assertTrue(accountAfterProcessing.getIsAccountActive(), "Account should be active. ");

    }

    @Test
    @DisplayName("test account service - new Account")
    public void testAccountServiceNewAccount() {

        AccountDto accountDto = AccountDto.builder().userId(102L).accountNumber("112233")
                .firstName("James").lastName("Bond").ifscCode("9865")
                .isAccountActive(true).isDebitCardActive(true)
                .build();

        accountService.updateAccountDetails(accountDto);

        AccountCompositeKey accountCompositeKey = AccountCompositeKey.builder()
                .userId(102L)
                .accountNumber("112233")
                .build();

        final Optional<Account> accountOptionalAfterProcessing = accountRepository.findById(accountCompositeKey);
        Assertions.assertTrue(accountOptionalAfterProcessing.isPresent(), "Account should be present");

        Account accountAfterProcessing = accountOptionalAfterProcessing.orElse(new Account());

        verify(accountMapper, times(1)).convertDtoToEntity(any());
        Assertions.assertEquals(102L, accountAfterProcessing.getAccountCompositeKey().getUserId(), "User Id should match. ");
        Assertions.assertEquals("112233", accountAfterProcessing.getAccountCompositeKey().getAccountNumber(), "Account number should match. ");
        Assertions.assertEquals("James", accountAfterProcessing.getFirstName(), "First name should match. ");
        Assertions.assertEquals("Bond", accountAfterProcessing.getLastName(), "Last name should match. ");
        Assertions.assertTrue(accountAfterProcessing.getIsDebitCardActive(), "Debit card should be active. ");
        Assertions.assertTrue(accountAfterProcessing.getIsAccountActive(), "Account should be active. ");

    }
}
