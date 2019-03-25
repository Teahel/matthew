package com.teahel.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//对于没有后缀的文件没有办法复制，考虑想法是，先使用修改后缀名称的办法，添加特定的后缀作为标志，文件复制成功之后在针对这些特定的后缀，去掉。
public class Main {
    public static boolean flag=false;
   public static String copyPath="D:\\testFile\\test";
   public static String path="D:\\testFile\\apache-maven-3.6.0";
    public static  void main (String arg[])throws IOException{
              queryName(path,copyPath);
    }

    public static void queryName(String path,String copyPath)throws IOException{

        File coFile=new File(copyPath);
        coFile.mkdirs();
        File file=new File(path);
        System.out.println(file.listFiles());
        File []  fils=file.listFiles();
        for(int i=0;i<fils.length;i++){
            if(fils[i].isFile()){
                System.out.println(fils[i].getName());
                String ss=fils[i].getName();
                char p='.';
                if(ss.indexOf(p)!=-1){
                    copyFile(fils[i],new File(copyPath+fils[i].getName()));
                }

            }
            if(fils[i].isDirectory()){
                copyDirectory(path+File.separator+fils[i].getName(),copyPath+File.separator+fils[i].getName());
            }
        }
    }

    public  static  void copyDirectory(String path,String copyPaths)throws IOException{
        (new File(copyPaths)).mkdirs();
        File file=new File(path);
        File []  fils=file.listFiles();
        for(int i=0;i<fils.length;i++){
            if(fils[i].isFile()){
                String ss=fils[i].getName();
                char p='.';
                if(ss.indexOf(p)!=-1){
                    copyFile(fils[i],new File(copyPaths+File.separator+fils[i].getName()));
                };
                System.out.println(copyPaths+File.separator+fils[i].getName());

                System.out.println(fils[i].getName());
            }

            if(fils[i].isDirectory()){
                copyDirectory(path+File.separator+fils[i].getName(),copyPaths+File.separator+fils[i].getName());
            }
        }
    }

    public static  void  copyFile(File sources,File target) throws IOException {
        //新建文件输入流并对它进行缓存
        FileInputStream input=new FileInputStream(sources);
        BufferedInputStream inBuff=new BufferedInputStream(input);

        //新建文件输入流并对它进行缓冲
        FileOutputStream output=new FileOutputStream(target);
        BufferedOutputStream outBuff=new BufferedOutputStream(output);

        //缓冲数组
        byte[] b=new byte[1024*5];
        int len;
        while ((len=inBuff.read(b))!=-1){
          outBuff.write(b,0,len);
        }
        //刷新此缓存的输出流
        outBuff.flush();

        //关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }
}
