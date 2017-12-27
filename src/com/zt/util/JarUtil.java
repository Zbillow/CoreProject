/*
 * Copyright 2012-2017 hchbox.com All right reserved. This software is the
 * confidential and proprietary information of hchbox.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with hchbox.com.
 */
package com.zt.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 类JarUtil.java的实现描述： 
 * @author zhangtao  2017-12-27 上午10:23:37
 */
public class JarUtil {

    /**
     * 解压jar文件到指定目录
     * @param fileName
     * @param outputPath
     */
    public static synchronized void decompress(String fileName, String outputPath) {
        // 保证输出路径为目录
        if (!outputPath.endsWith(File.separator)) {
            outputPath += File.separator;
        }
        // 如果不存在输出目录，则创建
        File dir = new File(outputPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 解压到输出目录
        JarFile jf = null;
        try {
            jf = new JarFile(fileName);
            for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements(); ) {
                JarEntry je = e.nextElement();
                String outFileName = outputPath + je.getName();
                File f = new File(outFileName);
                if (je.isDirectory()) {
                    if (!f.exists()) {
                        f.mkdirs();
                    }
                } else {
                    File pf = f.getParentFile();
                    if (!pf.exists()) {
                        pf.mkdirs();
                    }
                    InputStream in = jf.getInputStream(je);
                    OutputStream out = new BufferedOutputStream(
                            new FileOutputStream(f));
                    byte[] buffer = new byte[2048];
                    int nBytes;
                    while ((nBytes = in.read(buffer)) > 0) {
                        out.write(buffer, 0, nBytes);
                    }
                    out.flush();
                    out.close();
                    in.close();
                }
            }
        } catch (Exception e) {
            System.out.println("解压" + fileName + "出错！" + e.getMessage());
        } finally {
            if (jf != null) {
                try {
                    jf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

