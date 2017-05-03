package CHKMath.DataStructure;

/**
 * Created by caihongji on 2017/4/26.
 * 数据结构：向量
 */
public class Vector {
    private double[] raw;
    private Vector() {}
    public static Vector create(double... raw) {
        Vector vec = new Vector();
        vec.raw = raw;
        return vec;
    }
    public static Vector create(int capacity) {
        Vector vec = new Vector();
        vec.raw = new double[capacity];
        return vec;
    }
    public double get(int i) { return raw[i]; }
    public void set(int i, double val) { raw[i] = val; }
    public int length() { return raw.length; }
    public double infiniteNorm() {
        double max = 0;
        for (double r : raw) {
            double abs_r = abs(r);
            if (abs_r > max) max = abs_r;
        }
        return max;
    }
    public void div(double v) {
        for (int i = 0; i < raw.length; i++)
            raw[i] = raw[i] / v;
    }

    public static double abs(double a) {
        return (a <= 0.0D) ? 0.0D - a : a;
    }

}
