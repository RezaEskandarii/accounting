package com.accounting;

import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void TestCanCreateNewAccount() {
        var ac = new AccountDTO();
        ac.setCode("1234");
        ac.setDescription("just for test");
        ac.setName("receivable account");
        ac.setRoot(false);

        var result = accountService.create(ac);

        assertNotEquals(result.getId(), 0);
        assertNotNull(result);
        assertEquals(ac.getCode(), result.getCode());
    }
}
