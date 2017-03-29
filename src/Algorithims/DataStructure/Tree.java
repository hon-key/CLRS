package Algorithims.DataStructure;

/**
 * Created by caihongji on 2017/3/29.
 * 数据结构 : 二叉树、任意有根树
 */
public class Tree {
    private static class IntObject {
        int raw;
        public IntObject(int raw) { this.raw = raw; }
        public void add(int val) { this.raw += val; }
    }
    public static class BinaryTree {
        public BinaryTree parent;
        public BinaryTree leftChild,rightChild;
        public int value;


        public BinaryTree (int value) {
            this.value = value;
        }

        public int[] allValue() {
            int[] output = new int[count()];
            IntObject zero = new IntObject(0);
            traversal(output,zero);
            return output;
        }
        private void traversal(int[] output,IntObject index) {
            output[index.raw] = value;
            if (leftChild != null) {
                index.add(1); leftChild.traversal(output,index);
            }
            if (rightChild!= null) {
                index.add(1); rightChild.traversal(output,index);
            }
        }
        public int count() {
            int count = 1;
            if (leftChild != null) count += leftChild.count();
            if (rightChild!= null) count += rightChild.count();
            return count;
        }
    }




}
