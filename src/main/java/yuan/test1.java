package yuan;

import java.util.Scanner;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a,b;
        System.out.println("输入坐标x和y：");
        a=scanner.nextInt();
        b=scanner.nextInt();

        cricle cl=new cricle(10,new point(0,0)) ;//半径和圆心
        point pl=new point(a,b);//坐标
        System.out.println(cl.isCricleIn(pl));
    }

}
