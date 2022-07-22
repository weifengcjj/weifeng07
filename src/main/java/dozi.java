import java.util.Random;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class dozi {
    int x;
    int y;

    public dozi() {
    }
    public dozi(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void init()
    {
        Random random=new Random();
        this.x=random.nextInt(100);
        this.y=random.nextInt(100);
    }
    public void updatax(int sum)
    {
        this.x+=sum;
    }
}
