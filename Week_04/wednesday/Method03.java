package wednesday;

public class Method03 extends Calculation {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        int[] result = new int[1];

        new Thread(() -> {
            synchronized(result) {
                result[0] = sum();
                result.notifyAll();
            }
        }).start();

        synchronized(result) {
            while (result[0] == 0) {
                result.wait();
            }
            System.out.println("异步计算结果为："+ result[0]);      
            System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
        }
    }
}