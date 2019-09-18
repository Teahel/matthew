package com.matthew.socket;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.socket
 * @CreateDate: 2019/9/17 11:15
 * @Version: 1.0
 */
public class t10 {

    public static void main(String[] args) {
        new ServerO("D:\\clonefile\\logs",8089);
    }
}

class ServerO {
    private String path;
    private int port;
    private ServerSocket ss;

    public ServerO(String s, int p) {
        this.path = s;
        this.port = p;
        try {
            ss = new ServerSocket(port);
            while (true) {
                Socket soc = ss.accept();
                new Thread(new OOOO(soc,path)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            try {
                ss.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}

class OOOO implements Runnable {
    private Socket soc;
    private String path;
    public OOOO(Socket soc,String pa) {
        this.soc = soc;
        this.path=pa;
    }

    @Override
    public void run() {
        DataInputStream in = null;
        String name;
        byte[] b= new byte[1024];
        int i;
        try {
            in = new DataInputStream(soc.getInputStream());
            name=in.readUTF();
            String pass=name.substring(2);//去掉D:
            String pathss []= pass.split("\\|");//将|左右两边的数据和路劲切割开
            path=path+pathss[0];//本地路径+同步过来的文件路径。
            pass=path.replace("\\"+pathss[1],"");//判断文件夹是否已经创建，如果没有使用mkdirs进行创建。
            File filepath=new File(pass);
            if(!filepath.exists()){
                filepath.mkdirs();
            }
            File ss =new File(path);
            FileOutputStream bos = new FileOutputStream(ss);
            while((i=in.read(b))!=-1){
                bos.write(b,0,i);
            }
            bos.close();
        } catch (IOException e) {
            System.out.println("run中出现异常");
            e.printStackTrace();
        }finally{
            try {
                in.close();
                soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
