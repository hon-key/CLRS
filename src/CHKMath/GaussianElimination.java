package CHKMath;

import CHKMath.DataStructure.*;

/**
 * Created by caihongji on 2017/4/26.
 * 算法：高斯消去
 */
public class GaussianElimination {

    // 定义结果集数据结构,用于集合输出全主元以及列主元高斯消去的结果P、A、Q,比较方便
    public static class Result {
        public Matrix A;
        public Matrix[] P,Q;
    }

    private GaussianElimination() {}

    /*
     * 不选主元高斯消去
     */
    public static Matrix Eliminate(Matrix mat) throws Exception {
        Matrix A = mat.clone();
        if (!A.isSquareMatrix()) throw new Exception("参数不是方阵");
        for (int k = 0; k <= A.n() - 2; k++) {
            step1(A,k);
            step2(A,k);
        }
        return A;
    }

    /*
     * 全主元高斯消去
     */
    public static Result Eliminate_FullMainEle(Matrix mat) throws Exception {
        Matrix A = mat.clone();
        Matrix[] P = new Matrix[A.n()-1];
        Matrix[] Q = new Matrix[A.n()-1];
        if (!A.isSquareMatrix()) throw new Exception("参数不是方阵");
        for (int k = 0; k <= A.n() - 2; k++) {
            int[] pq = findMax_fullMainEle(A,k);
            int p = pq[0], q = pq[1];
            A.exchangeRow(k,p);
            A.exchangeCol(k,q);
            P[k] = createExchangeMatrix(A.n(),k,p);
            Q[k] = createExchangeMatrix(A.n(),k,q);
            if (A.get(k,k) == 0) throw new Exception("矩阵奇异");
            step1(A,k);
            step2(A,k);
        }
        Result re = new Result();
        re.A = A; re.P = P; re.Q = Q;
        return re;
    }

    /*
     * 列主元高斯消去
     */
    public static Result Eliminate_ColMainEle(Matrix mat) throws Exception {
        Matrix A = mat.clone();
        Matrix[] P = new Matrix[A.n()-1];
        if (!A.isSquareMatrix()) throw new Exception("参数不是方阵");
        for (int k = 0; k <= A.n() - 2; k++) {
            int p = findMax_colMainEle(A,k);
            A.exchangeRow(k,p);
            P[k] = createExchangeMatrix(A.n(),k,p);
            if (A.get(k,k) == 0) throw new Exception("矩阵奇异");
            step1(A,k);
            step2(A,k);
        }
        Result re = new Result();
        re.A = A; re.P = P; re.Q = null;
        return re;
    }

    // 从方阵中查询最大值的坐标
    private static int[] findMax_fullMainEle(Matrix A,int k) {
        double max = Double.MIN_VALUE;
        int[] pq = new int[2];
        for (int i = k; i <= A.n() - 1; i++) {
            for (int j = k; j <= A.n() - 1; j++) {
                double val = A.get(i,j);
                if (val > max) {
                    max = val;
                    pq[0] = i; pq[1] = j;
                }
            }
        }
        return pq;
    }
    // 从列向量中查询最大值的坐标
    private static int findMax_colMainEle(Matrix A,int k) {
        double max = Double.MIN_VALUE;
        int p = 0;
        for (int i = k; i <= A.n() - 1; i++) {
            double val = A.get(i,k);
            if (val > max) {
                max = val;
                p = i;
            }
        }
        return p;
    }
    // 生成置换矩阵
    private static Matrix createExchangeMatrix(int n,int p,int q) throws Exception {
        Matrix I = Matrix.createI(n);
        I.exchangeCol(p,q);
        return I;
    }


    // 高斯消去核心步骤1
    private static void step1(Matrix A,int k) {
        for (int i = k+1; i <= A.n()-1; i++) {
            A.set(i,k,
                    A.get(i,k) / A.get(k,k)
            );
        }
    }
    // 高斯消去核心步骤2
    private static void step2(Matrix A,int k) {
        for (int i = k+1; i <= A.n()-1; i++) {
            for (int j = k+1; j <= A.n()-1; j++) {
                A.set(i,j,
                        A.get(i,j) - A.get(i,k) * A.get(k,j)
                );
            }
        }
    }
}

