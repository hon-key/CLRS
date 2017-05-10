package Algorithims.DynamicProgramming;

import CHKMath.DataStructure.Matrix;
import com.sun.org.apache.bcel.internal.generic.RET;
import javafx.scene.control.Tab;
import sun.jvm.hotspot.debugger.posix.elf.ELFException;

/**
 * Created by caihongji on 2017/5/8.
 * 算法:矩阵链
 */
public class MatrixChainOrder {
    public static class Table {
        private int[][] raw;
        public Table(int n) { raw = new int[n][n]; }
        public int get(int i,int j) { return raw[i-1][j-1];}
        public void set(int i, int j, int val) { raw[i-1][j-1] = val; }
    }
    public static class Result {
        public Table m;
        public Table s;
        public int n;
        public void printOptimalParens(int i, int j) {
            if (i == j) System.out.print("A" + i);
            else {
                System.out.print("(");
                printOptimalParens(i,s.get(i,j));
                printOptimalParens(s.get(i,j) + 1,j);
                System.out.print(")");
            }
        }
    }

    public static Result cal(int... p) {
        int n = p.length - 1;
        Table m = new Table(n);
        Table s = new Table(n);
        for (int i = 1; i <= n; i++)
            m.set(i,i,0);
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n-l+1; i++) {
                int j = i+l-1;
                m.set(i,j,Integer.MIN_VALUE);
                for (int k = i; k <= j-1; k++) {
                    int q = m.get(i, k) + m.get(k + 1, j) + p[i - 1] * p[k] * p[j];
                    if (q > m.get(i,j)) {
                        m.set(i,j,q); s.set(i,j,k);
                    }
                }
            }
        }
        Result re = new Result();
        re.m = m; re.s = s; re.n = n;
        return re;
    }

    public static Result memoizedCal(int ... p) {
        int n = p.length - 1;
        Table m = new Table(n);
        Table s = new Table(n);
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j++)
                m.set(i,j,Integer.MIN_VALUE);
        lookupChain(m,s,p,1,n);
        Result re = new Result();
        re.m = m;re.n = n;re.s = s;
        return re;
    }
    private static int lookupChain(Table m,Table s,int[] p,int i, int j) {
        if (m.get(i,j) > Integer.MIN_VALUE)
            return m.get(i, j);
        if (i == j) m.set(i,j,0);
        else {
            for (int k = i; k <= j-1; k++) {
                int q = lookupChain(m,s,p,i,k)
                        + lookupChain(m,s,p,k+1,j) + p[i-1] * p[k] * p[j];
                if (q > m.get(i,j)) {
                    m.set(i, j, q);
                    s.set(i,j,k);
                }
            }
        }
        return m.get(i,j);
    }
}
