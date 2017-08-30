package learn;


import java.util.Scanner;

/**
 * 主要对Java线程的wait()、sleep()、notify()和notifyAll()进行测试
 */
public class ThreadTest {

    public static void main(String[] strings) throws InterruptedException {
        ThreadTest test = new ThreadTest();
        test.startAndWaitAllThread()
        ;
        Thread.sleep(2000);
        test.notifyAllWaitThread();

//        test.waitThread();
//        test.notifyWaitThread();
//        test.waitThread();
//        test.notifyWaitThread();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("任意输入，唤醒线程：");
//        scanner.nextLine();
//        test.notifyWaitThread();

    }

    /**
     * 对象锁
     */
    private final Object object = new Object();

    /**
     *
     * 使用Object.wait()方法使得线程进入等待状态，使得该线程释放了该线程拥有的monitor
     * 使用wait方法，必须使用Object的notify和notifyAll来让线程重新获取到monitor对象，唤醒线程
     *
     */
    private void startAndWaitAllThread(){
        String names[] = {"A", "B", "C", "D", "E"};
        for (int i = 0; i < names.length; i ++){
            Thread thread = new Thread(new MyRunnable(names[i]));
            thread.start();
        }
    }

    private void userRunnable(){
        Runnable runnable = ()->{
          System.out.println("使用Runnable开启多线程");
            synchronized(object){
                try {
                    System.out.println("线程进入wait状态");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程被唤醒，并结束");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private class MyRunnable implements Runnable{

        private String name;
        public MyRunnable(String name){
            this.name = name + "线程";
        }

        @Override
        public void run() {
            System.out.println(name + "启动");
            synchronized (object){
                try {
                    System.out.println(name + "进入wait状态");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + "被唤醒并执行结束");
        }
    }

    private void notifyWaitThread(){
//        Thread t = new Thread(()->{
//            synchronized(object){
//                System.out.println("开始唤醒等待中的线程");
//                object.notify();
//            }
//
//        });
//        t.start();
        synchronized(object){
            System.out.println("开始唤醒等待中的线程");
            object.notify();
        }
    }

    private void notifyAllWaitThread(){
        synchronized (object){
            System.out.println("唤醒所有等待中的线程");
            object.notifyAll();
        }
    }

    /**
     * sleep是Thread的方法，可使得当前线程进入休眠状态，但是和Object的wait方法的区别在于，使用sleep方法线程没有释放对应的monitor对象，不需要通过notify来唤醒，时间走完就恢复
     * @param millis
     */
    private void sleepThread(long millis){
        Thread thread = new Thread(()->{
           System.out.println("sleepThread创建");
           System.out.println("sleepThread进入睡眠状态，时长为：" + millis);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleepThread睡眠结束，被唤醒了");
        });
        thread.start();
    }
}
