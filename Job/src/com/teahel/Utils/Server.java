package com.teahel.Utils;

import javafx.concurrent.Task;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/3/23
 * Time: 23:27
 * Description: 服务器类型
 */
public class Server extends ServerSocket {
    private static final int SERVER_PORT=1996;//服务器端口
    private static DecimalFormat df=null;

    static {
        df=new DecimalFormat("#0.0");//格式化 保留一位小数
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMinimumFractionDigits(1);
        df.setMaximumFractionDigits(1);
    }
    public Server() throws Exception{
        super(SERVER_PORT);
    }

    public void  load()throws  Exception{
        while (true){
            Socket socket=this.accept();
            new Thread(new Task(socket)).start();
        }
    }

    class Task implements Runnable{
        private Socket socket;
        private DataInputStream dis;
        private FileOutputStream fos;

        public Task(Socket socket){
            this.socket=socket;
        }
        public void run(){
            try {
                dis=new DataInputStream(socket.getInputStream());

                //文件名和长度
                String fileName =dis.readUTF();
                long fileLength=dis.readLong();
                File direcory=new File("D:\\PrjectTestFile\\test2");
                if(!direcory.exists()){
                    direcory.mkdirs();
                }
                File file=new File(direcory.getAbsolutePath()+File.separator+fileName);
                fos=new FileOutputStream(file);

                //开始接收文件
                byte []bytes =new byte[1024];
                int length=0;
                while ((length=dis.read(bytes,0,bytes.length))!=-1){
                    fos.write(bytes,0,length);
                    fos.flush();
                }
                System.out.println("==============文件接收成功[file Name:"+fileName+"][Size :"+getFormatFileSize(fileLength));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if(fos!=null){
                        fos.close();
                    }
                    if(dis!=null){
                        dis.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }
    }

    //文件大小
    private String getFormatFileSize(long length){
        double size =((double)length)/(1<<30);
        if(size>=1){
            return df.format(size)+"GB";
        }
        size=((double)length)/(1<<20);
        if(size>=1){
            return  df.format(size)+"MB";
        }
        size=((double)length)/(1<<10);
        if(size>=1){
            return  df.format(size)+"KB";
        }
        return length+"B";
    }

    public  static void main (String args[]){
     try{
        Server server=new Server();
        server.load();
     }catch (Exception e){
        e.printStackTrace();
     }
    }
}
