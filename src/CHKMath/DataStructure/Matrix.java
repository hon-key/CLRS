package CHKMath.DataStructure;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

/**
 * Created by caihongji on 2017/4/26.
 * 数据结构：矩阵
 */
public class Matrix {
    private double[][] raw;
    private Matrix(){}
    public static Matrix create(double[][] raw) {
        Matrix mat = new Matrix();
        mat.raw = raw;
        return mat;
    }
    // 创建单位矩阵
    public static Matrix createI(int n) {
        Matrix mat = new Matrix();
        mat.raw = new double[n][n];
        for (int i = 0; i <= n-1; i++)
            mat.raw[i][i] = 1;
        return mat;
    }
    public double get(int i, int j) { return raw[i][j];}
    public void set(int i, int j, double val) { raw[i][j] = val; }
    // 方阵的阶数
    public int n() {
        if (isSquareMatrix())
            return raw.length;
        return -1;
    }
    public boolean isSquareMatrix() {
        if (raw.length != raw[0].length) return false;
        return true;
    }
    public Matrix clone() {
        Matrix newMat = new Matrix();
        newMat.raw = this.raw.clone();
        for (int i = 0; i < raw[0].length; i++)
            newMat.raw[i] = raw[i].clone();
        return newMat;
    }

    public void exchangeRow(int r1, int r2) throws Exception {
        if (r1 < 0 || r1 >= raw.length || r2 < 0 || r2 >= raw.length)
            throw new Exception("参数超出矩阵范围");
        double[] tmp = raw[r1];
        raw[r1] = raw[r2];
        raw[r2] = tmp;
    }
    public void exchangeCol(int c1, int c2) throws Exception {
        if (c1 < 0 || c1 >= raw[0].length || c2 < 0 || c2 >= raw[0].length)
            throw new Exception("参数超出矩阵范围");
        for (int i = 0; i <= raw.length - 1; i++) {
            double tmp = raw[i][c1];
            raw[i][c1] = raw[i][c2];
            raw[i][c2] = tmp;
        }
    }

    public void print() {
        for (double[] row : raw) System.out.println(Arrays.toString(row));
    }

}
