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
    public double get(int i) { return raw[i]; }
    public void set(int i, double val) { raw[i] = val; }

}
