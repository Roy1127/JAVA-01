package wednesday;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Method10 extends Calculation {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        final Lock LOCK = new ReentrantLock();
        final Condition CONDITION = LOCK.newCondition();

        int[] result = new int[1];

        new Thread(() -> {
            LOCK.lock();
            try {
                result[0] = sum();
                CONDITION.signalAll();
            } finally {
                LOCK.unlock();
            }
        }).start();

        try {
            LOCK.lock();
            while (result[0] == 0) {
                CONDITION.await();
            }
            System.out.println("异步计算结果为：" + result[0]);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}
