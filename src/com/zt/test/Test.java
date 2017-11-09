/*
 * Copyright 2012-2017 hchbox.com All right reserved. This software is the
 * confidential and proprietary information of hchbox.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with hchbox.com.
 */
package com.zt.test;

import java.text.ParseException;

import com.zt.util.IDCardUtil;

/**
 * 类Test.java的实现描述： 
 * @author zhangtao  2017-9-5 上午10:24:43
 */
public class Test {

    /**
     * @param args 
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
//        String text="团队账号 WP15168796163";
//        System.out.println( text.replaceFirst(".*?[\\pP+]", "").replace("团队账号", "").trim());
//        //IDCardUtil.isValid("532130199508061737");
        String id ="532130199508061737";
        System.out.println( IDCardUtil.isValid("532130199508061737"));
//        String birth = id.length() == 15 ? "19" + id.substring(6, 12) : id.substring(6, 14);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Date birthDate = sdf.parse(birth);
//        System.out.println(birth);
//        System.out.println(birthDate);
//        IDCardUtil.generateID();
//        System.out.println(IDCardUtil.id15To18("532130199508061"));
//        String str = ""+"sad"+""+"";
//        if(str.contains("")){
//            System.out.println(true);
//        }
//            String s="新疆维吾尔族自治区";
//            System.out.println(s.equals(""));
//            if(!(1==1)){
//                System.out.println(1);
//            }
//            System.out.println(2);
        //        String str=null;
//        if ("true".equals(str)) {
//            System.err.println(1);
//        }
    }
    

}
