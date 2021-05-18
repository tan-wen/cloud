package com.aoyang.bis.common.utils;

import java.io.*;

/**
 * @ClassName : ReadFileUtil
 * @Description :
 * @Author : GC
 * @Date: 2021-04-28 18:51
 */
public class ReadFileUtil {
    /**
     * 一次性读取文件
     * //path  =C:/temp/newTemp.txt
     */
    public static String readToString(String path,String encoding) {
        //String encoding = "UTF-8";
        if(encoding.equals("")) {
            encoding = "UTF-8";
        }
        File file = new File(path);
        if (file.isFile() && file.exists()) { //判断文件是否存在
            Long filelength = file.length();
            byte[] filecontent = new byte[filelength.intValue()];
            try {
                FileInputStream in = new FileInputStream(file);
                in.read(filecontent);
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                return new String(filecontent, encoding);
            } catch (UnsupportedEncodingException e) {
                System.err.println("The OS does not support " + encoding);
                e.printStackTrace();
                return null;
            }
        }
        else {
            return  null;
        }

    }
    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static StringBuffer readFileByBytes(String path) {
        File file = new File(path);
        InputStream in = null;
        StringBuffer sb = new StringBuffer();
        if (file.isFile() && file.exists()) { //判断文件是否存在
            try {
                // System.out.println("以字节为单位读取文件内容，一次读多个字节：");
                // 一次读多个字节
                byte[] tempbytes = new byte[100];
                int byteread = 0;
                in = new FileInputStream(path);
                //ReadFromFile.showAvailableBytes(in);
                // 读入多个字节到字节数组中，byteread为一次读入的字节数
                while ((byteread = in.read(tempbytes)) != -1) {
                    //   System.out.write(tempbytes, 0, byteread);
                    String str = new String(tempbytes, 0, byteread);
                    sb.append(str);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }
        else {
            // logger.info("找不到指定的文件，请确认文件路径是否正确");
        }
        return  sb;
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String path) {
        File file = new File(path);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(path));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    /**文件转换为字节数组
     * @param file
     * @return
     */
    public static byte[] fileToByteArray(File file) {
        byte[] imagebs = null;
        try {
            //读取输入的文件====文件输入流
            FileInputStream fis = new FileInputStream(file);
            //字节数组输出流  在内存中创建一个字节数组缓冲区，所有输出流的数据都会保存在字符数组缓冲区中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            //将文件读入到字节数组中
            while ((len = fis.read(buffer)) != -1) {
                // 将指定字节数组中从偏移量 off 开始的 len 个字节写入此字节数组输出流。
                baos.write(buffer, 0, len);
            }
            imagebs = baos.toByteArray();//当前输出流的拷贝  拷贝到指定的字节数组中

            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imagebs;

    }
    public static byte[] InputStreamToByteArray(InputStream inputStream) {
        byte[] imagebs = null;
        try {
            //字节数组输出流  在内存中创建一个字节数组缓冲区，所有输出流的数据都会保存在字符数组缓冲区中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            //将文件读入到字节数组中
            while ((len = inputStream.read(buffer)) != -1) {
                // 将指定字节数组中从偏移量 off 开始的 len 个字节写入此字节数组输出流。
                baos.write(buffer, 0, len);
            }
            imagebs = baos.toByteArray();//当前输出流的拷贝  拷贝到指定的字节数组中
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagebs;

    }
}
