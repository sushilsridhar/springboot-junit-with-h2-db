package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountCompositeKey implements Serializable {

    private static final long serialVersionUID = -6671129559315296182L;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
}
