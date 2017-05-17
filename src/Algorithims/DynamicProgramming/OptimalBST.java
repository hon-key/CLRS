package Algorithims.DynamicProgramming;


/**
 * Created by caihongji on 2017/5/15.
 * 算法： 最优二叉搜索树
 */
public class OptimalBST {
    public static class Table {
        private double[][] raw;
        public Table(int n,int m) { raw = new double[n+1][m+1]; }
        public double get(int i,int j) { return raw[i][j];}
        public void set(int i, int j, double val) { raw[i][j] = val; }
    }
    public static final String LEFT = "左";
    public static final String RIGHT = "右";
    public static class Result {
        public Table e;
        public Table root;
        private int n;
        public void printOptimalBST() {
            int r = (int) root.get(1,n);
            System.out.println("k" + r + " (root)");
            printOptimalBST(1,r-1,r,LEFT);
            printOptimalBST(r+1,n,r,RIGHT);
        }
        private void printOptimalBST(int i, int j, double parent,String direction) {
            if (j < i) {
                System.out.println("d" + j + "为 " + "k" + (int)parent +" 的" + direction + "孩子");
                return;
            }
            int r = (int) root.get(i,j);
            System.out.println("k" + r + "为 " + "k" + (int)parent + " 的" + direction + "孩子");
            printOptimalBST(i,r-1,r,LEFT);
            printOptimalBST(r+1,j,r,RIGHT);
        }
    }
    public static Result cal(double[] p,double[] q) throws Exception {
        if (p.length != q.length) throw new Exception("p.length != q.length");
        int n = p.length-1;
        Table e = new Table(n+1,n);
        Table w = new Table(n+1,n);
        Table root = new Table(n,n);
        for (int i = 1; i <= n+1; i++) {
            e.set(i,i-1,q[i-1]);
            w.set(i,i-1,q[i-1]);
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n-l+1; i++) {
                int j = i+l-1;
                e.set(i,j,Double.MAX_VALUE);
                w.set(i,j,w.get(i,j-1)+p[j]+q[j]);
                for (int r = i; r <= j; r++) {
                    double t = e.get(i,r-1) + e.get(r+1,j) + w.get(i,j);
                    if (t < e.get(i,j)) {
                        e.set(i,j,t);
                        root.set(i,j,r);
                    }
                }
            }
        }
        Result re = new Result();
        re.e = e; re.root = root;re.n = n;
        return re;
    }

}
