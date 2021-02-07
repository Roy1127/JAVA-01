package wednesday;

public class Method01 extends Calculation{
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        int[] result = new int[1];

        Thread newT = new Thread(() -> result[0] = sum());

        newT.start();
        newT.join();
        
        System.out.println("异步计算结果为："+ result[0]);
         
        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
    }
}
