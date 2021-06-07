package dto;

import lombok.Data;

@Data
public class AccountDto {

    private Long userId;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String ifscCode;
    private Boolean isAccountActive;
    private Boolean isDebitCardActive;
}
