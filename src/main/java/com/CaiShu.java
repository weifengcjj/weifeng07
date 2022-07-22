package com;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class CaiShu {
    public static void main(String[] args) {
        Random rd=new Random();
        int i=rd.nextInt(9);
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int number=sc.nextInt();
        int x=3;
        for(int a=0;a<3;a++)
        {

            if (number < i) {
                System.out.println("猜小了");
            } else if (number > i) {
                System.out.println("猜大了");
            } else if (number==i){
                System.out.println("恭喜你，答对了");
                break;
            }
            if (a == 2) {
                System.out.println("抱歉机会用完了....");
                System.exit(0);
            }
            System.out.println("请在输入一个数字:");
            number=sc.nextInt();

        }
    }

}
