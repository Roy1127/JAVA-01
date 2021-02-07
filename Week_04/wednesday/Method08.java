package wednesday;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Method08 extends Calculation{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] result = new int[1];

        final CyclicBarrier barrier = new CyclicBarrier(1, () -> {
            System.out.println("异步计算结果为："+ result[0]); 
            System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
        });

        new Thread(() -> {
            result[0] = sum();
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
