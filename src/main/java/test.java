/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class test {
    public static void main(String[] args) {
        dozi dozi=new dozi();
        dozi.init();
        System.out.println("豆子坐标为:  X："+dozi.x+" Y："+dozi.y);


        snake snake=new snake();
        snake.add();
        snake.init();
        System.out.println("蛇身长为："+snake.getBody());
        System.out.println("蛇坐标为: X:"+snake.getSnakeX()+"  Y:"+snake.getSnakeY());
        snake.set(dozi.x,dozi.y);
        System.out.println("蛇坐标为: X:"+snake.getSnakeX()+"  Y:"+snake.getSnakeY());
        snake.add();
        System.out.println("蛇身长为："+snake.getBody());

    }
}
