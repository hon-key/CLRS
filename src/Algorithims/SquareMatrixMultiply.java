package Algorithims;

/**
 * Created by caihongji on 2017/3/15.
 * 算法 : 矩阵相乘
 */
public class SquareMatrixMultiply {

    public static int[][] multi(int[][] A,int[][] B) {
        Range rA = new Range(0,A.length - 1);
        Matrix MA = new Matrix(A,rA,rA);
        Range rB = new Range(0,B.length - 1);
        Matrix MB = new Matrix(B,rB,rB);
        return strassen(MA,MB).raw;
    }

    /*
     *  Data Structure
     */
    private static class Range {
        public int begin;
        public int end;
        public Range(int begin,int end) { this.begin = begin; this.end = end; }
        public int capacity() { return end - begin + 1; }
    }
    private static class Matrix {
        public Range i;
        public Range j;
        public int[][] raw;
        public Matrix(int[][] raw,Range i,Range j) {
            this.i = i; this.j = j; this.raw = raw;
        }
        public Matrix(int capacity) {
            i = new Range(0,capacity - 1);
            j = new Range(0,capacity - 1);
            this.raw = new int[capacity][capacity];
        }
        public int get(int i,int j) { return raw[this.i.begin + i][this.j.begin + j]; }

        public static Matrix add(Matrix... matrix) {
            int capacity = matrix[0].i.capacity();
            Matrix newMatrix = new Matrix(capacity);
            for (int i = 0; i < capacity; i++) {
                for (int j = 0; j < capacity; j++) {
                    for (Matrix m : matrix) {
                        newMatrix.raw[i][j] += m.get(i,j);
                    }
                }
            }
            return newMatrix;
        }
        public static Matrix less(Matrix base,Matrix... matrix) {
            int capacity = base.i.capacity();
            Matrix newMatrix = Matrix.add(base);
            for (int i = 0; i < capacity; i++) {
                for (int j = 0; j < capacity; j++) {
                    for (Matrix m : matrix) {
                        newMatrix.raw[i][j] -= m.get(i,j);
                    }
                }
            }
            return newMatrix;
        }
    }
    private static class BreakDown {
        Matrix _11;Matrix _12;Matrix _21;Matrix _22;
        private BreakDown() {}
        public static BreakDown breakdown(Matrix m) {
            BreakDown b = new BreakDown();
            int subCapacity = m.i.capacity() / 2;
            int firstHalf_i_begin = m.i.begin;
            int firstHalf_i_end = m.i.begin + subCapacity - 1;
            int firstHalf_j_begin = m.j.begin;
            int firstHalf_j_end = m.j.begin + subCapacity - 1;
            int secondHalf_i_begin = m.i.begin + subCapacity;
            int secondHalf_i_end = m.i.end;
            int secondHalf_j_begin = m.j.begin + subCapacity;
            int secondHalf_j_end = m.j.end;

            Range _11i = new Range(firstHalf_i_begin,firstHalf_i_end);
            b._11 = new Matrix(m.raw,_11i,_11i);
            Range _12j = new Range(secondHalf_j_begin,secondHalf_j_end);
            Range _12i = new Range(firstHalf_i_begin,firstHalf_i_end);
            b._12 = new Matrix(m.raw,_12i,_12j);
            Range _21j = new Range(firstHalf_j_begin,firstHalf_j_end);
            Range _21i = new Range(secondHalf_i_begin,secondHalf_j_end);
            b._21 = new Matrix(m.raw,_21i,_21j);
            Range _22i = new Range(secondHalf_i_begin,secondHalf_i_end);
            b._22 = new Matrix(m.raw,_22i,_22i);
            return b;
        }
    }
    private static class CreateS {
        Matrix S1,S2,S3,S4,S5,S6,S7,S8,S9,S10;
        private CreateS() {}
        public static CreateS create(BreakDown A,BreakDown B) {
            CreateS s = new CreateS();
            s.S1 = Matrix.less(B._12,B._22);
            s.S2 = Matrix.add(A._11,A._12);
            s.S3 = Matrix.add(A._21,A._22);
            s.S4 = Matrix.less(B._21,B._11);
            s.S5 = Matrix.add(A._11,A._22);
            s.S6 = Matrix.add(B._11,B._22);
            s.S7 = Matrix.less(A._12,A._22);
            s.S8 = Matrix.add(B._21,B._22);
            s.S9 = Matrix.less(A._11,A._21);
            s.S10 = Matrix.add(B._11,B._12);
            return s;
        }
    }
    private static class CreateP {
        public Matrix P1,P2,P3,P4,P5,P6,P7;
        private CreateP() {}
        public static CreateP create(BreakDown A,BreakDown B,CreateS S) {
            CreateP p = new CreateP();
            p.P1 = strassen(A._11,S.S1);
            p.P2 = strassen(S.S2,B._22);
            p.P3 = strassen(S.S3,B._11);
            p.P4 = strassen(A._22,S.S4);
            p.P5 = strassen(S.S5,S.S6);
            p.P6 = strassen(S.S7,S.S8);
            p.P7 = strassen(S.S9,S.S10);
            return p;
        }
    }
    private static class CreateC {
        public Matrix C11,C12,C21,C22;
        private CreateC() {}
        public static CreateC create(CreateP P) {
            CreateC c = new CreateC();
            c.C11 = Matrix.add(P.P5,P.P4,P.P6);
            c.C11 = Matrix.less(c.C11,P.P2);
            c.C12 = Matrix.add(P.P1,P.P2);
            c.C21 = Matrix.add(P.P3,P.P4);
            c.C22 = Matrix.add(P.P5,P.P1);
            c.C22 = Matrix.less(c.C22,P.P3,P.P7);
            return c;
        }
    }
    private static class Merge {
        private Merge() {}
        public static Matrix merge(CreateC c) {
            int capacity = c.C11.i.capacity() * 2;
            Matrix newMatrix = new Matrix(capacity);
            assign(newMatrix,c.C11,0,0);
            assign(newMatrix,c.C12,0,c.C11.j.end + 1);
            assign(newMatrix,c.C21,c.C11.i.end + 1,0);
            assign(newMatrix,c.C22,c.C11.i.end + 1,c.C11.j.end + 1);
            return newMatrix;
        }
        private static void assign(Matrix target,Matrix source,int begin_i,int begin_j) {
            for (int i = source.i.begin;i <= source.i.end;i++) {
                for (int j = source.j.begin;j <= source.j.end;j++) {
                    target.raw[begin_i + i][begin_j + j] = source.raw[i][j];
                }
            }
        }
    }
    private static Matrix strassen(Matrix A,Matrix B) {
        if (A.i.capacity() == 1) {
            Matrix m = new Matrix(1);
            m.raw[0][0] = A.raw[A.i.begin][A.j.begin] * B.raw[B.i.begin][B.j.begin];
            return m;
        }
        BreakDown breakDownA = BreakDown.breakdown(A);
        BreakDown breakDownB = BreakDown.breakdown(B);
        CreateS s = CreateS.create(breakDownA,breakDownB);
        CreateP p = CreateP.create(breakDownA,breakDownB,s);
        CreateC c = CreateC.create(p);
        return Merge.merge(c);
    }
}
