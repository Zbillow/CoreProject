/*
 * Copyright 2012-2017 hchbox.com All right reserved. This software is the
 * confidential and proprietary information of hchbox.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with hchbox.com.
 */
package com.zt.test;

/**
 * 类Singleton.java的实现描述： 
 * @author zhangtao  2017-9-30 下午3:14:56
 */
public class Singleton {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
    private static Singleton instance = null;  
  
    /* 私有构造方法，防止被实例化 */  
    private Singleton() {  
    }  
  
    /* 静态工程方法，创建实例 */  
//    public static Singleton getInstance() {  
//        if (instance == null) {  
//            instance = new Singleton();  
//        }  
//        return instance;  
//    }  
    /* 线程同步 */
    public static Singleton getInstance() {  
        if (instance == null) {  
            synchronized (instance) {  
                if (instance == null) {  
                    instance = new Singleton();  
                }  
            }  
        }  
        return instance;  
    }  
    /* 此处使用一个内部类来维护单例 */  
//    private static class SingletonFactory {  
//        private static Singleton instance = new Singleton();  
//    }  
    private static class SingletonFactory{
        private static Singleton ins=new Singleton();
    }
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return instance;  
    }
    
    
}
