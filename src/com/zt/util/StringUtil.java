/**
 * Project: taomi File Created at 2011-8-14 Copyright 2011 NorthStar Studio. All rights reserved. This software is the
 * confidential and proprietary information of NorthStar Studio. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the terms of the license agreement you entered
 * into with NorthStar Studio.
 */
package com.zt.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串处理的工具类
 * 
 * @version 1.0
 * @date 2007-4-20
 */
public class StringUtil extends StringUtils {

//    private static final Logger LOGGER           = Logger.getLogger(StringUtil.class);
    public static final String  CHARSET_ENCODING = "UTF-8";

    public static final int     LIMIT_NUMBER     = 34;
    
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    private StringUtil(){
    }

    /**
     * 检查字符串数组中是否包含指定的字符串。。
     * 
     * <pre>
     * StringUtil.contains({"a","b"}, "a")    = true
     * </pre>
     * 
     * @param array 字符串数组
     * @param str 要查找的字符串
     * @return 如果找到，则返回<code>true</code>
     */
    public static boolean contains(String[] array, String str) {
        if (array == null || isEmpty(str)) return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(String con, String str) {
        if (isBlank(con) || isBlank(str)) {
            return false;
        }
        return con.indexOf(str) >= 0;
    }

    public static boolean isEmpty(String[] array) {
        return array == null || array.length <= 0 ? true : false;
    }

    /**
     * 检查给定的字符串中是否包含中文信息
     * 
     * @param info
     * @return
     */
    public static boolean isChineseString(String string) {
        if (string == null) return false;

        String patternRange = "[\\u4E00-\\u9FA5]+";
        Pattern pattern = Pattern.compile(patternRange);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    /**
     * 截断字符串，只适用中文和单字节表示字符的国家
     * 
     * @param str
     * @param byteLength
     * @return
     */
    public static String limit(String str, int byteLength) {

        if (str == null) {
            return null;
        }
        if (byteLength <= 0) {
            return "";
        }
        try {
            if (str.getBytes(StringUtil.CHARSET_ENCODING).length <= byteLength) {
                return str;
            }
        } catch (UnsupportedEncodingException e) {
//            LOGGER.error(e.getMessage(), e);
        }
        StringBuffer buff = new StringBuffer();
        int index = 0;
        char c;
        char[] arr = new char[1];
        while (byteLength > 0) {
            c = str.charAt(index);
            arr[0] = c;
            if (!isChineseString(new String(arr))) {
                byteLength--;
            } else {
                byteLength--;
                byteLength--;
            }
            buff.append(c);
            index++;
        }
        buff.append("...");
        return buff.toString();

    }

    /**
     * 将String中Null转换成""
     * 
     * @param string
     * @return
     */
    public static String nullToString(String string) {
        if (string == null) return "";
        return string;
    }

    /**
     * 将String aaBc 转为 aa_bc的格式 用于java bean 属性转为数据库字段名
     * 
     * @param str
     * @return
     */
    public static String propertyToFieldName(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.charAt(0) > 'A' && str.charAt(0) < 'Z') {
            return str;
        }
        if (Character.isUpperCase(str.charAt(0))) {
            str = Character.toString(Character.toLowerCase(str.charAt(0))) + str.substring(1);
        }

        for (int i = 1; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a >= 'A' && a <= 'Z') {
                if (str.charAt(i - 1) != '_') {
                    str = str.replace(a + "", ("_" + a).toLowerCase());
                    i++;
                }
                continue;
            }
        }

        return str;
    }

    public static String trimStr(String str) {
        return StringUtils.trimToEmpty(str).replaceAll("[\\r\\n]", "");
    }

    /**
     * 通过字符串驻留池的方式比较
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean intern(String str1, String str2) {
        if (str1 == null) return str2 == null;

        return (str1.intern() == str2) ? true : false;
    }

    public static String arrayToString(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int strsLen;
        if (strs == null || (strsLen = strs.length) == 0) {
            return "";
        }
        for (int i = 0; i < strsLen; i++) {
            sb.append(strs[i] + ",");
        }
        return sb.toString();
    }

    public static String changeArray(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int strsLen;
        if (strs == null || (strsLen = strs.length) == 0) {
            return "";
        }
        for (int i = 0; i < strsLen; i++) {
            sb.append(strs[i] + ",");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static String listToString(List<Object> objList) {
        StringBuffer sb = new StringBuffer();
        if (objList == null) {
            return "";
        }
        for (Object obj : objList) {
            sb.append(obj.toString() + ",");
        }
        return sb.toString();
    }

    /**
     * 按分隔符把str转换为List，去除每个字符串的空白
     * 
     * @param str
     * @param regex
     * @return
     */
    public static List<String> strToList(String str, String regex) {

        if (isEmpty(str)) {
            return null;
        }

        String[] strArray = str.split(regex);
        List<String> strList = new ArrayList<String>();
        for (int index = 0; index < strArray.length; index++) {
            strList.add(strArray[index].trim());
        }

        return strList;
    }

    public static String escapeSQL(String str) {
        if (isEmpty(str)) {
            return null;
        }

        return str.replaceAll("'", "").replaceAll("\"", "").replaceAll("\\*", "");

    }
    
    /**
     * 模糊数据
     * <pre>
     * StringUtil.changeInfo("123456")=123****
     * StringUtil.changeInfo("abcd")=ab****
     * </pre>
     * 
     * @param info
     * @return
     */
    public static String changeInfo(String info){
        
        if (StringUtil.isBlank(info)) {
            return "";
        }

        String i = info.toString();
        return i.substring(0, i.length()/2) + "****";
    }

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    /**
     * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    /**
     * 驼峰转下划线,效率比上面高
     * @param str
     * @return
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * object转String
     * @param object
     * @return
     */
    public static String getString(Object object) {
        return getString(object, "");
    }

    public static String getString(Object object, String defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return object.toString();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转Integer
     * @param object
     * @return
     */
    public static int getInt(Object object) {
        return getInt(object, -1);
    }

    public static int getInt(Object object, Integer defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(object.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转Boolean
     * @param object
     * @return
     */
    public static boolean getBoolean(Object object) {
        return getBoolean(object, false);
    }

    public static boolean getBoolean(Object object, Boolean defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(object.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }
}

