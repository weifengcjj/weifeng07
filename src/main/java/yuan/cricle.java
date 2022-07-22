package yuan;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class cricle {
    private double r;//半径
    private point center;//圆心

    public cricle(double r) {
        this.r=r;
    }
    public cricle(double r,point center) {
        this.r=r;
        this.center=center;
    }
    public double area(){//面积
        return Math.PI*r*r;
    }

    public double girth() {//周长
        return 2*Math.PI*r;
    }
    public double getr() {
        return r;
    }
    public double setr(double r) {
        return this.r=r;
    }
    public point getCenter() {
        return center;
    }
    public point setCenter(point center) {
        return this.center=center;
    }
    public boolean isCricleIn(point posion) {//判断点是否在圆内
        if(center.dis(posion)<=r)
            return true;
        else
            return false;
    }
}
