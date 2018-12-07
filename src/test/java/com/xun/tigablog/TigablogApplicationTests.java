package com.xun.tigablog;

import io.nebulas.account.Account;
import io.nebulas.account.AccountManager;
import io.nebulas.client.NebulasClient;
import io.nebulas.client.api.request.CallRequest;
import io.nebulas.client.api.request.Contract;
import io.nebulas.client.api.request.GetAccountStateRequest;
import io.nebulas.client.api.response.AccountState;
import io.nebulas.client.api.response.CallResult;
import io.nebulas.client.api.response.NebState;
import io.nebulas.client.api.response.Response;
import io.nebulas.client.impl.HttpNebulasClient;
import io.nebulas.core.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TigablogApplicationTests {

    @Autowired
    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(getClass());

    private NebulasClient nebulasClient = HttpNebulasClient.create("https://mainnet.nebulas.io");


    @Test
    public void contextLoads() throws SQLException {
        System.out.print(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.print(connection);
        connection.close();
    }

    @Test
    public void logTest() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");

    }

    @Test
    public void testGetNebState() {
        Response<NebState> response = nebulasClient.getNebState();
        logger.info("nebulas --》 " + response.toString());
    }

    @Test
    public void testGetAccountState() {
        Response<AccountState> response = nebulasClient.getAccountState(new GetAccountStateRequest("n1Qm81K83uS6QpS2VXuUVeV93nsvhmubD3A"));
        logger.info("nebulas2 --》" + response.toString());

    }

    @Test
    public void testAccountAddress() {
        try {
            AccountManager accountManager = new AccountManager();
            List<Address> addressList = accountManager.accounts();
            for (int i = 0; i < addressList.size(); i++) {
                logger.info("nebulas3 --》" + addressList.get(i).string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCall() {
        Response<CallResult> response =
                nebulasClient.call(new CallRequest("n1Qm81K83uS6QpS2VXuUVeV93nsvhmubD3A", "n1teWGepuWfDXbgKWkHXk9nRrHCx8nQS2Vh", "0", 3l, "1000000", "20000000", new Contract().setFunction("getAllPlayerInfo").setArgs("")));
        logger.info("nebulas4 --》" + response.getResult().getResult());
    }

}
