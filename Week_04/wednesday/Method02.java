package wednesday;

public class Method02 extends Calculation{
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        MyThread newT = new MyThread();

        newT.start();
        newT.join();

        int result = newT.getResult();
        
        System.out.println("异步计算结果为："+ result);
         
        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
    }
}

class MyThread extends Thread {

    private volatile int result;

    @Override
    public void run() {
        result = Method02.sum();
    }

    public int getResult() {
        return result;
    }
}
