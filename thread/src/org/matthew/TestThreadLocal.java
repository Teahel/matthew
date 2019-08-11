package org.matthew;

import java.text.SimpleDateFormat;

/**
 * @author : Matthew
 * @Date: 2019/8/12
 * @Time: 1:23
 * @Description: ThreadLocal类主要解决的就是让每个线程绑定自己的值，可以将ThreadLocal类形象的比喻成存放数据的盒子，盒子中可以存储每个线程的私有数据。
 */
public class TestThreadLocal implements  Runnable{
     // ThreadLocal就是用来避免这两个线程竞争
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String args[]) throws Exception{
        TestThreadLocal t=new TestThreadLocal();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(t,""+i);//
            Thread.sleep(500);
            thread.start();
        }
    }

    @Override
    public void run() {
      System.out.println("Thread name="+Thread.currentThread().getName()+" formatter="+formatter.get().toPattern());
      try{
          Thread.sleep(5000);
      }catch (Exception  e){
          e.printStackTrace();
      }
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }
}
