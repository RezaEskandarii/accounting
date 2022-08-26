package com.accounting;

import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.interfaces.AccountAppService;
import com.accounting.contract.interfaces.AccountGroupAppService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @Autowired
    private AccountAppService accountAppService;

    @Autowired
    private AccountGroupAppService accountGroupAppService;

    @Test
    public void TestCanCreateNewAccount() {

        var ag = accountGroupAppService.create(new AccountGroupDto());

        var ac = new AccountCreateDto();
        ac.setName("test");
        ac.setCode("1002");
        ac.setRoot(false);
        ac.setDescription("test");

        var result = accountAppService.create(ac);
        assertNotNull(result);


    }

}


