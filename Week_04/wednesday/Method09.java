package wednesday;

import java.util.concurrent.Semaphore;

public class Method09 extends Calculation {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Semaphore semaphore = new Semaphore(1);
        int[] result = new int[1];

        semaphore.acquire();
        new Thread(() -> {
            result[0] = sum();
            semaphore.release();
        }).start();

        semaphore.acquire();
        System.out.println("异步计算结果为：" + result[0]);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        semaphore.release();
    }
}
