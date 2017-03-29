package Algorithims.DataStructure;

/**
 * Created by caihongji on 2017/3/29.
 * 数据结构 : 二叉树
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

        public int[] allValue(boolean recursion) {
            int[] output = new int[count()];
            IntObject zero = new IntObject(0);
            if (recursion) traversal(output,zero);
            else  traversalWithNoRecursion(output,zero);
            return output;
        }
        private void traversalWithNoRecursion(int[] output,IntObject index) {
            BinaryTree[] bt = new BinaryTree[output.length];
            Stack<BinaryTree> stack = new Stack(bt);
            BinaryTree node = this;
            stack.push(node);
            while (stack.hasNext()) {
                node = stack.pop();
                output[index.raw] = node.value;
                index.add(1);
                if (node.leftChild != null) stack.push(node.leftChild);
                if (node.rightChild != null) stack.push(node.rightChild);
            }

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
