package com.aoyang.bis.common.utils;

import java.util.List;

/**
 * @ClassName : StringUtils
 * @Description : 字符串构造工具
 * @Author : GC
 * @Date: 2021-05-14 16:52
 */
public class MyStringUtils {

    public static String buildTouser(List<String> list){
        if(list.size()<=1){
            return list.get(0);
        }else {
            String re="";
            for (String s : list) {
                re+=s + "|";
            }
            int i = re.lastIndexOf("|");
            return re.substring(0, i);
        }
    }
}
