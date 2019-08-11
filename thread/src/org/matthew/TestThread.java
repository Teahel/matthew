package org.matthew;

/**
 * @author : Matthew
 * @Date: 2019/8/12
 * @Time: 0:48
 * @Description: 继承Thread 实现多线程
 */
class ThreadDemo extends Thread{
    private Thread thread;
    private String threadName;
    ThreadDemo(String name){
        threadName=name;
     System.out.println("线程名字："+threadName);
    }
    public void run(){
        System.out.println("开始："+threadName);
        try{
            System.out.println("等待："+threadName);
            Thread.sleep(5000);
            System.out.println("等待结束："+threadName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void start(){
        if(thread==null){
            thread=new Thread(this,threadName);
            thread.start();
        }
    }

}

public class TestThread {
    public static void main(String args[]){
        ThreadDemo threadDemo=new ThreadDemo("two");
        threadDemo.start();
    }

}
