package com.teahel.Utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/3/23
 * Time: 22:59
 * Description: 客户端类 向服务端传送一个文件
 */
public class Client  extends Socket {
    private static final  String SERVER_IP="127.0.0.1";//服务器ip
    private static  final int SERVER_PORT=1996;//服务器端端口
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    public Client()throws Exception{
        super(SERVER_IP,SERVER_PORT);
        this.client=this;
        System.out.println("Client[port:"+client.getLocalPort()+"]成功连接服务器");
    }

    public void sendFile() throws  Exception{
        try{
           File file=new File("D:\\PrjectTestFile\\test1\\testREADME.txt");

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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
             if(fis!=null){
                 fis.close();
             }
             if(dos!=null){
                 dos.close();
                 client.close();
             }
        }
    }

    public static void main (String []args){
        try{
            Client client =new Client();
            client.sendFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
