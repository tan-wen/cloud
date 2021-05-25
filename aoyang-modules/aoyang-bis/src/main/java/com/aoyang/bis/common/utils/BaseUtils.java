package com.aoyang.bis.common.utils;

import org.springframework.util.Assert;
 
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseUtils {
    private final static String SET = "set";
    private final static String GET = "get";
    private final static String IS = "is";

    /**
     * copyProperties
     * @param source
     * @param target
     * @throws Exception
     */
    public static void copyProperties (Object source,Object target)throws Exception{
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
 
        Map<String,Object> valueMap = getFieldValueMap(source);
        setFieldValue(target,valueMap);
    }
 
    /**
     * 取出bean的值放到map中
     * @param bean
     * @return
     */
    public static Map<String,Object> getFieldValueMap(Object bean)throws Exception{
        Class<?> beanClass = bean.getClass();
        //获取bean的所有方法
        Method[] methods = beanClass.getDeclaredMethods();
        //获取bean的所有字段
        Field[] fields = beanClass.getDeclaredFields();
 
        Map<String,Object> valueMap = new HashMap<>();

        for (Field field : fields) {
            try {
                //获取字段的类型
                String fieldType = field.getType().getSimpleName();//String  boolean
                String fieldType1 = field.getType().getName();//java.lang.String  boolean
 
                Method fieldGetMet;
                String fieldName = field.getName();
                if ("boolean".equals(fieldType)||"Boolean".equals(fieldType)){
                    if(!IS.equals(fieldName.substring(0,2))){
                        fieldName = IS + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                    }else {
                        fieldName = IS + fieldName.substring(2,3).toUpperCase() + fieldName.substring(3);
                    }
                    //获取boolean的isXxx方法
                    fieldGetMet = beanClass.getMethod(fieldName,new Class[]{});
                }else{
                    //获取字段get的方法名
                    String fieldGetName = parGetOrSetName(fieldName,GET);
                    //获取字段的get方法
                    fieldGetMet = beanClass.getMethod(fieldGetName,new Class[]{});
                }
                //判断有没有该方法
                if (!checkMethod(methods,fieldGetMet)) {
                    continue;
                }
                //获取字段的值
                Object fieldVal = fieldGetMet.invoke(bean,new Object[]{});
                if(fieldVal != null){
                    valueMap.put(field.getName(),fieldVal);
                }
            }catch (Exception e){
               throw new RuntimeException("构建map失败: "+e);
            }
        }
        return valueMap;
    }
 
    /**
     * 把属性值放到bean
     * @param bean
     * @param valueMap
     */
    public static void setFieldValue(Object bean, Map<String, Object> valueMap)throws Exception{
        Class<?> beanClass = bean.getClass();
        //获取bean的所有方法
        Method[] methods = beanClass.getDeclaredMethods();
        //获取bean的所有字段
        Field[] fields = beanClass.getDeclaredFields();



        for (Field field : fields) {
            try {
                //获取字段的类型
                String fieldType = field.getType().getSimpleName();
                String fieldName = field.getName();
                if (("boolean".equals(fieldType)||"Boolean".equals(fieldType))
                        && "is".equals(fieldName.substring(0, 2))){
                    fieldName = fieldName.substring(2);
                }
                //获取字段set的方法名
                String fieldSetName = parGetOrSetName(fieldName,SET);

                //获取字段的set方法

                Method fieldSetMet = null;
                try {
                    fieldSetMet = beanClass.getMethod(fieldSetName,field.getType());
                } catch (NoSuchMethodException e) {
                    //判断没有该方法
                    continue;
                } catch (SecurityException e) {
                    throw new RuntimeException("构建对象失败: "+e);
                }

                //判断有没有该方法
                if (!checkMethod(methods,fieldSetMet)) {
                    continue;
                }
                Object value = valueMap.get(field.getName());
                if (value != null) {

                    if(value instanceof List || value instanceof Map){
                        fieldSetMet.invoke(bean,value.toString());
                    }else {
                        fieldSetMet.invoke(bean,value);
                    }
                }
 
            }catch (Exception e){
               throw new RuntimeException("构建对象失败: "+e);
            }
        }
    }
 
    /**
     * 拼接set或get方法
     * @param fieldName
     * @return
     */
   private static String parGetOrSetName(String fieldName,String met){
       if (null == fieldName || "".equals(fieldName)) {
           return null;
       }
       return met + fieldName.substring(0, 1).toUpperCase()
               + fieldName.substring(1);
   }
 
    /**
     * 判断类是否存在该方法
     * @param methods
     * @param met
     * @return
     */
   private static boolean checkMethod(Method[] methods,Method met){
       if (met == null) {
           return false;
       }
       for (Method method : methods) {
           if (met.equals(method)) {
               return true;
           }
       }
       return false;
   }
 
}