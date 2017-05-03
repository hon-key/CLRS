package CHKMath;

import CHKMath.DataStructure.*;

/**
 * Created by caihongji on 2017/5/2.
 * 算法：Householder 变换
 */
public class Householder {

    public static class House {
        double β;
        Vector v;
        public House(int capacity) {
            β = 0;
            v = Vector.create(capacity);
        }
        public Matrix H() {
            Matrix H = Matrix.createI(v.length());
            double[][] raw = new double[v.length()][v.length()];
            for (int i = 0; i <= raw.length-1; i++)
                for (int j = 0; j <= raw[0].length-1; j++)
                    H.set(i,j,
                            H.get(i,j) - β * v.get(i) * v.get(j)
                    );
            return H;
        }
    }
    private Householder() {}
    public static House convert(Vector x) {

        House house = new House(x.length());

        preventOverlow(x);

        initv(house,x);

        double σ = getσ(x);
        if (σ == 0)
            house.β = 0;
        else
        {
            setV1(house,x,σ);
            double v1 = house.v.get(1);
            house.β = (2 * v1 * v1) / (σ + v1 * v1);
            house.v.div(v1);
        }
        return house;
    }
    private static void preventOverlow(Vector x) {
        double in = x.infiniteNorm();
        x.div(in);
    }
    private static double getσ (Vector x) {
        int sig = 0;
        for (int i = 1; i <= x.length() - 1; i++) {
            double xi = x.get(i);
            sig += xi * xi;
        }
        return sig;
    }
    private static void initv(House house,Vector x) {
        house.v.set(0,1);
        for (int i = 1; i <= x.length() - 1; i++)
            house.v.set(i,
                    x.get(i)
            );
    }
    private static void setV1(House house,Vector x,double σ) {
        double x1 = x.get(1);
        double α = Math.sqrt(x1 * x1 + σ);
        if (x1 <= 0)
            house.v.set(1,
                    x1 - α
            );
        else
            house.v.set(1,
                    (-σ) / (x1 + α)
            );
    }


}
