package Algorithims.DynamicProgramming;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * Created by caihongji on 2017/5/10.
 * 算法：最长公共子序列
 */
public class LCS {
    public static class Table {
        private int[][] raw;
        public Table(int n,int m) { raw = new int[n+1][m+1]; }
        public int get(int i,int j) { return raw[i][j];}
        public void set(int i, int j, int val) { raw[i][j] = val; }
    }
    public static class Result {
        public Table c; public Table b;
        private String[] X,Y;
        public void printLCS() {
            print(X.length,Y.length);
            System.out.print("\n");
        }
        private void print(int i,int j) {
            if (i==0 || j ==0) return;
            if (b.get(i,j) == TOPLEFT) {
                print(i - 1, j - 1);
                System.out.print(X[i-1]);
            }
            else if (b.get(i,j) == TOP)
                print(i-1,j);
            else
                print(i,j-1);
        }
        public void printLCS_Nob() {
            printWithNob(X.length,Y.length);
            System.out.print("\n");
        }
        private void printWithNob(int i,int j) {
            if (i == 0 || j == 0) return;
            if (X[i-1] == Y[j-1]) {
                printWithNob(i - 1, j - 1);
                System.out.print(X[i-1]);
            }else if (c.get(i-1,j) >= c.get(i,j-1))
                printWithNob(i-1,j);
            else
                printWithNob(i,j-1);
        }
    }
    public static final int TOP = 1;
    public static final int LEFT = 2;
    public static final int TOPLEFT = 3;
    public static Result getLCS(String[] X,String[] Y) {
        int m = X.length;
        int n = Y.length;
        Table c = new Table(m,n);
        Table b = new Table(m,n);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i-1] == Y[j-1]) {
                    c.set(i, j, c.get(i - 1, j - 1) + 1);
                    b.set(i,j,TOPLEFT);
                }
                else if (c.get(i-1,j) >= c.get(i,j-1)) {
                    c.set(i,j,c.get(i-1,j));
                    b.set(i,j,TOP);
                }
                else {
                    c.set(i,j,c.get(i,j-1));
                    b.set(i,j,LEFT);
                }
            }
        }
        Result re = new Result();
        re.b = b;re.c = c;
        re.X = X.clone();
        re.Y = Y.clone();
        return re;
    }

    public static Result getLCS_Backup(String[] X,String[] Y) {
        int m = X.length;
        int n = Y.length;
        Table c = new Table(m,n);
        Table b = new Table(m,n);
        for (int i = 1; i <= m;i++)
            for (int j = 1; j <= n; j++)
                c.set(i,j,-1);
        calTableItem(X,Y,c,b,m,n);
        Result re = new Result();
        re.X = X.clone();re.Y = Y.clone();
        re.b = b;re.c = c;
        return re;
    }
    private static int calTableItem(String[] X,String[] Y,Table c,Table b,int i,int j) {
        if (c.get(i,j) >= 0) return c.get(i,j);
        if (X[i-1] == Y[j-1]) {
            c.set(i, j, calTableItem(X, Y, c, b, i - 1, j - 1) + 1);
            b.set(i, j, TOPLEFT);
        }
        else {
            int top = calTableItem(X,Y,c,b,i-1,j);
            int left = calTableItem(X,Y,c,b,i,j-1);
            if (top >= left) {
                c.set(i,j,top);
                b.set(i,j,TOP);
            }
            else {
                c.set(i,j,left);
                b.set(i,j,LEFT);
            }
        }
        return c.get(i,j);
    }
}
