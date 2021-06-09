package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

    private Long userId;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String ifscCode;
    private Boolean isAccountActive;
    private Boolean isDebitCardActive;
}
