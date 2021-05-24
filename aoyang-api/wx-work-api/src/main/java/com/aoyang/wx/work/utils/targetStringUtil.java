package com.aoyang.wx.work.utils;

import java.util.List;

/**
 * @ClassName : targetStringUtil
 * @Description :
 * @Author : GC
 * @Date: 2021-05-24 09:10
 */

public class targetStringUtil {
    public static String buildTarget(List<String> list){
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
