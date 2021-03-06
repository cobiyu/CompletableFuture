package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class CompletableFutureTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public CompletableFuture<Integer> goodsPriceApi() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("goodsPriceApi start");
                TimeUnit.SECONDS.sleep(5);
                logger.info("goodsPriceApi success");
                return 30000;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public CompletableFuture<String> userNameApi() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("userNameApi start");
                TimeUnit.SECONDS.sleep(5);
                logger.info("userNameApi success");
                return "user1's name";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    @Test
    public void orderApi() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> goodsApiFuture = goodsPriceApi();
        CompletableFuture<String> userApiFuture = userNameApi();

        Integer goodsPrice = goodsApiFuture.get();
        String userName = userApiFuture.get();

        logger.info("username : " + userName + ", goodsPrice : " + goodsPrice);
    }
}
