package com.publicissapient.creditcardsystem;

import com.publicissapient.creditcardsystem.web.rs.AccountResource;
import com.publicissapient.creditcardsystem.web.rs.CustomerResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CreditCardSystemApplicationTests {

    @Autowired
    private AccountResource accountResource;
    @Autowired
    private CustomerResource customerResource;

    @Test
    void contextLoads() throws Exception {
    	assertThat(accountResource).isNotNull();
    	assertThat(customerResource).isNotNull();
    }

}
