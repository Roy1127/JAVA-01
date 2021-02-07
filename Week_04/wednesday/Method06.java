package wednesday;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Method06 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        FutureTask<Integer> task = new FutureTask<>(Calculation :: sum);
        new Thread(task).start();

        System.out.println("异步计算结果为："+ task.get()); 
        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
    }
}