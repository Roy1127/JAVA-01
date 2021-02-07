package wednesday;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Method04 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService ex = Executors.newFixedThreadPool(1);
        Future<Integer> f = ex.submit(Calculation :: sum);

        System.out.println("异步计算结果为："+ f.get());
         
        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
    }
}