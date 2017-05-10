package CHKMath;

import CHKMath.DataStructure.*;

/**
 * Created by caihongji on 2017/4/26.
 * 算法：Cholesky 分解
 */
public class CholeskyFactorization {
    /*
     * Cholesky 分解
     */
    public static Matrix Eliminate(Matrix mat) {
        Matrix A = mat.clone();
        double[] v = new double[A.n()-1];
        for (int j = 0; j <= A.n() - 1; j++) {
            step1(A,v,j);
            step2(A,v,j);
        }
        return A;
    }

    // Cholesky 分解核心步骤1
    private static void step1(Matrix A,double[] v,int j) {
        for (int i = 0;i <= j-1; i++) {
            v[i] = A.get(j, i) * A.get(i, i);
            A.set(j,j,
                    A.get(j,j) - A.get(j,i)*v[i]
            );
        }
    }
    // Cholesky 分解核心步骤2
    private static void step2(Matrix A,double[] v,int j)
    {
        for (int i = j+1; i <= A.n()-1; i++) {

            for (int k = 0; k <= j-1; k++)
            {
                A.set(i, j,
                        A.get(i, j) - A.get(i, k) * v[k]
                );
            }

            A.set(i,j,
                    A.get(i,j) / A.get(j,j)
            );

        }
    }
}
