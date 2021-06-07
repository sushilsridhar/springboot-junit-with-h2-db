package entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
public class AccountCompositeKey implements Serializable {

    private static final long serialVersionUID = -6671129559315296182L;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
}
