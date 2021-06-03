package service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import utils.EnableH2Database;


@EnableH2Database
@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AccountServiceTest {
}
