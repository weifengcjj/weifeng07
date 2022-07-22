import java.util.Random;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class snake {
    private int body;
    private  int snakeX;
    private  int snakeY;

    public snake() {
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getSnakeX() {
        return snakeX;
    }

    public void setSnakeX(int snakeX) {
        this.snakeX = snakeX;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public void setSnakeY(int snakeY) {
        this.snakeY = snakeY;
    }

    public snake(int body, int snakeX, int snakeY) {
        this.body = body;
        this.snakeX = snakeX;
        this.snakeY = snakeY;
    }
    public  void init()
    {
        Random random=new Random();
        this.snakeX=random.nextInt(100);
        this.snakeY=random.nextInt(100);
    }
    public void set(int x,int y)
    {
        this.snakeX=x;
        this.snakeY=y;
    }
    public void add()
    {
        this.body+=1;
    }
}
