package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT", schema = "TESTDB")
public class Account implements Serializable {

    private static final long serialVersionUID = 6151163367095964836L;

    @EmbeddedId
    private AccountCompositeKey accountCompositeKey;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "IFSC_CODE", nullable = false)
    private String ifscCode;

    @Column(name = "IS_ACCOUNT_ACTIVE")
    private Boolean isAccountActive;

    @Column(name = "IS_DEBIT_CARD_ACTIVE")
    private Boolean isDebitCardActive;

}
