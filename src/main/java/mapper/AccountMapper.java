package mapper;

import dto.AccountDto;
import entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AccountMapper {

    @Mappings(value = {
            @Mapping(source = "userId", target = "accountCompositeKey.userId"),
            @Mapping(source = "accountNumber", target = "accountCompositeKey.accountNumber"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "ifscCode", target = "ifscCode"),
            @Mapping(source = "isAccountActive", target = "isAccountActive"),
            @Mapping(source = "isDebitCardActive", target = "isDebitCardActive")
    })
    Account convertDtoToEntity(AccountDto accountDto);
}
