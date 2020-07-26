package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;


public class AsyncTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public CompletableFuture<Integer> goodsPriceApi() throws InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread( () ->{
            try {
                logger.info("goodsPriceApi start");
                TimeUnit.SECONDS.sleep(5);
                logger.info("goodsPriceApi success");
                completableFuture.complete(29000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return completableFuture;
    }

    public String userNameApi() throws InterruptedException {
        logger.info("userNameApi start");
        TimeUnit.SECONDS.sleep(5);
        logger.info("userNameApi success");
        return "user1's name";
    }

    @Test
    public void userNameAndGoodsApiTest() throws InterruptedException{
        CompletableFuture<Integer> goodsPriceApiFuture = goodsPriceApi();
        String userName = userNameApi();
        Integer goodsPrice = goodsPriceApiFuture.join();

        logger.info("username : " + userName + ", goodsPrice : " + goodsPrice);
    }
}
