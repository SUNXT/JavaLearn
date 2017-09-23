package learn;

/**
 * volatile具有可见性，不具有原子性
 * 验证volatile是否具有原子性
 */
public class VolatileTest {

    public volatile int inc = 0;

    public void increase(){
        inc ++;
    }

    public static void main(String[] args){
        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i ++){
            int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j ++){
                        test.increase();
//                        System.out.println("Thread-" + k);
                    }
                }
            }).start();
        }

        while (Thread.activeCount() > 2)//保证前面的线程都执行完
        {
            Thread.yield();
        }

        System.out.println(test.inc);

        /**
         * 测试得到的结果是，最后inc的值不一定是10000，出现了9656，原因是volatile没有原子性，且i++也是没有原子性的，所以才没有原子性
         */
    }
}
