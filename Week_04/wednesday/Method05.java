package wednesday;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Method05 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Calculation :: sum);

        System.out.println("异步计算结果为："+ future.get()); 
        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
    }
}
