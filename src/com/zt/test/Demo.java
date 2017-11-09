/*
 * Copyright 2012-2017 hchbox.com All right reserved. This software is the
 * confidential and proprietary information of hchbox.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with hchbox.com.
 */
package com.zt.test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 类Demo.java的实现描述： 
 * @author zhangtao  2017-9-6 上午10:35:16
 */
public class Demo {

    /*【程序1】
    题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
    假如兔子都不死，问每个月的兔子总数为多少？ 
    1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21.... 
    */
    public static void main(String[] args) {
//        int f1=1,f2=1,a=0;
//        for (int i =3; i < 10; i++) {
//            a=f2;
//            f2=f1+f2;
//            f1=a;
//            System.out.println(i+"月兔子数量为:"+f2);
//        }
        
        long f1 = 1L, f2 = 1L;
        long f;
        for(int i=3; i<10; i++) {
         f = f2;
         f2 = f1 + f2;
         f1 = f;
         System.out.print("第" + i +"个月的兔子对数: ");
         System.out.println(" " + f2);
        }
    }

}

/*【程序12】 
* 作者 若水飞天
题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，
可可提成7.5%；20万到40万之间时，高于20万元的部分，
可提成5%；40万到60万之间时高于40万元的部分，可提成3%；
60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，
从键盘输入当月利润I，求应发放奖金总数？ 
1.程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。 
*/
class TwelfthProfitAward {
static double profit = 0;
static double award = 0;
public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
   profit = s.nextInt();
   System.out.println("输入的利润是" + profit + "万");
   if(profit > 0 && profit <= 10) {
    award = profit * 0.1;
   } else if(profit > 10 && profit <= 20) {
    award = 10 * 0.1 + (profit - 10) * 0.075;
   } else if(profit > 20 && profit <= 40) {
    award = 10 * 0.1 + 10 * 0.075 + (profit - 20) * 0.05;
   } else if(profit > 40 && profit <= 60) {
    award = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (profit - 40) * 0.03;
   } else if(profit > 60 && profit <= 100) {
    award = 20 * 0.175 + 20 * 0.05 + 20 * 0.03 + (profit - 60) * 0.015; 
   } else if(profit > 100) {
    award = 20 * 0.175 + 40 * 0.08 + 40 * 0.015 + (profit - 100) * 0.01;
   }
   DecimalFormat df = new DecimalFormat("#0.00000");
  
   System.out.println("应该提取的奖金是 " + df.format(award) + "万");
}
}