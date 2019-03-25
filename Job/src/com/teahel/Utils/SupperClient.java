package com.teahel.Utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/3/24
 * Time: 0:49
 * Description: 向服务端发送多个文件
 */
public class SupperClient extends Socket {
    private static final  String SERVER_IP="127.0.0.1";//服务器ip
    private static  final int SERVER_PORT=1996;//服务器端端口

    ExecutorService executorService = Executors.newCachedThreadPool();
  /*  public SupperClient()throws Exception{
        super(SERVER_IP,SERVER_PORT);
        this.client=this;
        System.out.println("Client[port:"+client.getLocalPort()+"]成功连接服务器");
    }*/




    public void sendFile() throws  Exception{

        try{
            File temp=null;
            File file=new File("D:\\PrjectTestFile\\test1");
            File files[] =file.listFiles();

            for(int i=0;i<files.length;i++){
                if(files[i].isFile()){
                   // doTran(files[i]);
                    executorService.execute(tranSomething(files[i]));
                }
                if(files[i].isDirectory()){
                    queryFile(file.getAbsolutePath()+File.separator+files[i].getName());

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void queryFile(String directory){
        File tempFile=null;
        File file=new File(directory);
        File all[]=file.listFiles();
        for(int i=0;i<all.length;i++){
            if(all[i].isFile()){
                //doTran(all[i]);
                executorService.execute(tranSomething(all[i]));
            }
            if(all[i].isDirectory()){
                queryFile(directory+File.separator+all[i].getName());
            }

        }
    }
/*
    public void doTran(File file){
        try{
            if(file!=null){
                if(file.exists()){
                    fis=new FileInputStream(file);
                    dos=new DataOutputStream(client.getOutputStream());

                    //文件名和长度
                    dos.writeUTF(file.getName());
                    dos.flush();
                    dos.writeLong(file.length());
                    dos.flush();

                    //开始传输文件
                    System.out.println("---------开始传输文件-------------");
                    byte[] bytes=new byte[1024];
                    int length=0;
                    long progress=0;
                    while ((length=fis.read(bytes,0,bytes.length))!=-1){
                        dos.write(bytes,0,length);
                        dos.flush();
                        progress +=length;
                        System.out.println("|"+(100*progress/file.length())+"%|");
                    }
                    System.out.println();
                    System.out.println("==============文件传输成功=============");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(fis!=null){
                    fis.close();
                }
                if(dos!=null){
                    dos.close();
                    client.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }*/


   private static Runnable tranSomething(final File file){
        return new Runnable() {
            private Socket client;
            private FileInputStream fis;
            private DataOutputStream dos;
            @Override
            public void run() {
                try{
                    if(file!=null){
                        if(file.exists()){
                            if(Connection()){
                                fis=new FileInputStream(file);
                                dos=new DataOutputStream(client.getOutputStream());

                                //文件名和长度
                                dos.writeUTF(file.getName());
                                dos.flush();
                                dos.writeLong(file.length());
                                dos.flush();

                                //开始传输文件
                                System.out.println("---------开始传输文件-------------");
                                byte[] bytes=new byte[1024];
                                int length=0;
                                long progress=0;
                                while ((length=fis.read(bytes,0,bytes.length))!=-1){
                                    dos.write(bytes,0,length);
                                    dos.flush();
                                    progress +=length;
                                    System.out.println("|"+(100*progress/file.length())+"%|");
                                }
                                System.out.println();
                                System.out.println("==============文件传输成功=============");
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try{
                        if(fis!=null){
                            fis.close();
                        }
                        if(dos!=null){
                            dos.close();
                            client.close();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }

            public boolean Connection()  {
                try{
                    client =new Socket(SERVER_IP,SERVER_PORT);
                    return  true;
                }catch (Exception e)
                {
                    return false;
                }
            }
        };
   }




    public static void main (String []args){
        try{
            SupperClient client =new SupperClient();
            client.sendFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
