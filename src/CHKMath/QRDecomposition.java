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

    public static House[] decompose(Matrix A) throws Exception {
        int n = A.col(),m = A.row();

        House[] houses = new House[n];

        for (int j = 0; j <= n-1; j++)  {

            if (j < m-1) {

                houses[j] = getHouseHolder(A,j,m);

                matrixMultiply(houses,A,j,m,n);
            }
        }
        return houses;
    }

    private  static House getHouseHolder(Matrix A,int j,int m)
    {
        Vector subVec = A.subVector(Range.c(j,m-1),j);

        House house = Householder.convert(subVec);

        for (int i = j,c = 0; i <= m-1; i++,c++)
            A.set(i,j,subVec.get(c));
        return house;
    }
    private static void matrixMultiply(House[] houses,Matrix A,int j,int m,int n) throws Exception
    {
        Matrix H = houses[j].H();

        Matrix subA = A.subMatrix(Range.c(j,m-1),Range.c(j,n-1));

        subA = H.x(subA);

        for (int i = j,row = 0; i <= m-1; i++, row++)

            for (int k = j,col = 0; k <= n-1; k++, col++)

                A.set(i,k,subA.get(row,col));
    }
}
