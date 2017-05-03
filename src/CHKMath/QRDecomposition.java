package CHKMath;

import CHKMath.DataStructure.Vector;
import CHKMath.DataStructure.Matrix;
import CHKMath.DataStructure.Matrix.Range;
import CHKMath.Householder.*;

/**
 * Created by caihongji on 2017/5/2.
 * 算法：QR 分解
 */
public class QRDecomposition {

    private QRDecomposition() {}

    public static House[] decompose(Matrix A)
    {
        int n = A.col(),m = A.row();

        House[] houses = new House[n];

        for (int j = 0; j <= n-1; j++)
        {
            if (j < m-1)
            {
                houses[j] = Householder.convert(
                        A.subVector(Range.c(j,m-1),j)
                );

                matrixMultiply(houses,A,j,m,n);

            }
        }
        return houses;
    }
    private static void matrixMultiply(House[] houses,Matrix A,int j,int m,int n) {
        Matrix H = houses[j].H();
        for (int i = j; i <= m-1; i++)
        {
            for (int k = j;k <= n-1; k++) {
                double val = 0;
                for (int l = 0;l <= H.n() - 1; l++)
                    val += H.get(i,l) * A.get(l,k);
                A.set(i,k,val);
            }
        }
    }
}
