package com.xun.tigablog;

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


@RunWith(SpringRunner.class)
@SpringBootTest
public class TigablogApplicationTests {

    @Autowired
    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() throws SQLException {
        System.out.print(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.print(connection);
        connection.close();
    }

    @Test
    public void logTest(){
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");

    }

}
