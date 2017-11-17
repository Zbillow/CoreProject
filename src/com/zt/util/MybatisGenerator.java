package com.zt.util;
///*
// * Copyright 2012-2017 hchbox.com All right reserved. This software is the
// * confidential and proprietary information of hchbox.com ("Confidential
// * Information"). You shall not disclose such Confidential Information and shall
// * use it only in accordance with the terms of the license agreement you entered
// * into with hchbox.com.
// */
//package com.northstar.app.taomi.util;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.internal.DefaultShellCallback;
//
///**
// * 类MybatisGenerator.java的实现描述： 
// * @author zhangtao  2017-11-16 上午9:11:28
// */
//public class MybatisGenerator {
//
//    /**
//     * @param args 
//     */
//    public static void main(String[] args) throws Exception {
//        // TODO Auto-generated method stub
//            List<String> warnings = new ArrayList<String>();
//            boolean overwrite = true;
//            File configFile = new File("mbg.xml");
//            ConfigurationParser cp = new ConfigurationParser(warnings);
//            Configuration config = cp.parseConfiguration(configFile);
//            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//            myBatisGenerator.generate(null);
//            System.out.println("111");
//
//    }
//
//}
