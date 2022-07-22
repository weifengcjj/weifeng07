package yuan;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class point {
    private double x;
    private double y;
    public point(double x,double y) {
        this.x=x;
        this.y=y;
    }
    public double getx() {
        return x;
    }
    public void setx(double x) {
        this.x=x;
    }
    public double gety() {
        return y;
    }
    public void sety(double y) {
        this.y=y;
    }
    public double dis(point dot) {//点到圆心的距离公式
        return Math.sqrt(Math.pow(x-dot.x, 2))+Math.pow(y-dot.y, 2);
    }
}
