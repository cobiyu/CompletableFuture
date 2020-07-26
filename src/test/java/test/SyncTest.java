package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class SyncTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Integer goodsPriceApi() throws InterruptedException {
        logger.info("goodsPriceApi start");
        TimeUnit.SECONDS.sleep(5);
        logger.info("goodsPriceApi success");

        return 29000;
    }

    public String userNameApi() throws InterruptedException {
        logger.info("userNameApi start");
        TimeUnit.SECONDS.sleep(5);
        logger.info("userNameApi success");

        return "user1's name";
    }

    @Test
    public void userNameAndGoodsApiTest() throws InterruptedException, ExecutionException {
        Integer goodsPrice = goodsPriceApi();
        String userName = userNameApi();

        logger.info("username : " + userName + ", goodsPrice : " + goodsPrice);
    }
}
