package com.matthew.socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.socket
 * @CreateDate: 2019/9/17 11:15
 * @Version: 1.0
 */
public class t11 {
    public static void main(String[] args) {

        File f= new File("D:\\testfile");
        File [] files=f.listFiles();
        for(int j=0;j<files.length;j++){
            if(files[j].isFile()){
                doFile(files[j]);
            }else if(files[j].isDirectory()){
                folder(files[j]);
            }
        }

    }

    public  static void doFile(File file){
        Socket s = null;
        DataOutputStream data = null;
        InputStream is = null;
        try {
            s= new Socket("127.0.0.1", 8089);
            data = new DataOutputStream(s.getOutputStream());

            File f= file;

            is= new FileInputStream(f);
            byte[] b= new byte[(int) f.length()];
            is.read(b);
            data.writeUTF(f.getAbsolutePath()+"|"+f.getName());
            data.flush();
            data.write(b);
            data.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                is.close();
                data.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void folder(File file){
        File []files=file.listFiles();
        for(File file1:files){
            if(file1.isFile()){
                doFile(file1);
            }else if(file1.isDirectory()) {
                folder(file1);
            }
        }
    }
}
