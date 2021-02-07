package wednesday;

import java.util.concurrent.CountDownLatch;

public class Method07 extends Calculation{
    
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] result = new int[1];
        
        Thread thread = new Thread(() -> {
            result[0] = sum();
            COUNT_DOWN_LATCH.countDown();
        });
        thread.start();
        try {
            COUNT_DOWN_LATCH.await();
            System.out.println("异步计算结果为："+ result[0]); 
            System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
