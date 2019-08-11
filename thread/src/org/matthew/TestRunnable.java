package org.matthew;

/**
 * @author : Matthew
 * @Date: 2019/8/12
 * @Time: 0:36
 * @Description: 测试 Runnable 实现多线程
 */

class RunnableDemo implements Runnable{
    private  Thread thread;
    private String threadName;

    RunnableDemo(String name){
        threadName=name;
        System.out.println("Thread:"+threadName);
    }
    @Override
    public void run() {
        System.out.println("开始");
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    public void Strat(){
        if(thread==null){
            thread=new Thread(this,threadName);
            thread.start();
        }
    }
}
public class TestRunnable {
    public static void main(String args[]){
        RunnableDemo r1=new RunnableDemo("one");
        r1.Strat();
    }
}
