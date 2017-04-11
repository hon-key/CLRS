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
        public BinaryTree leftChild, rightChild;
        public int key;

        public BinaryTree(int value) {
            this.key = value;
        }

        public void setLeftChild(BinaryTree leftChild) throws Exception {
            int maxKey = this.key;
            BinaryTree firstRightAncestor = findFirstAncestor(AncestorType.rightAncestor);
            int minKey = firstRightAncestor != null ? firstRightAncestor.key : Integer.MIN_VALUE;
            if (leftChild.key >= minKey && leftChild.key <= maxKey) {
                this.leftChild = leftChild;
                leftChild.parent = this;
            }else throw new Exception("插入左孩子的值有误，需要在" + minKey + " - " + maxKey + "之间");
        }
        public void setRightChild(BinaryTree rightChild) throws Exception {
            int minKey = this.key;
            BinaryTree firstLeftAncestor = findFirstAncestor(AncestorType.leftAncestor);
            int maxKey = firstLeftAncestor != null ? firstLeftAncestor.key : Integer.MAX_VALUE;
            if (rightChild.key >= minKey && rightChild.key <= maxKey) {
                this.rightChild = rightChild;
                rightChild.parent = this;
            }else throw new Exception("插入右孩子的值有误，需要在" + minKey + " - " + maxKey + "之间");
        }
        private enum AncestorType {rightAncestor,leftAncestor}
        private BinaryTree findFirstAncestor(AncestorType type) {
            BinaryTree node = this.parent;
            BinaryTree preNode = this;
            while (node != null) {
                BinaryTree child = type == AncestorType.rightAncestor ? node.rightChild : node.leftChild;
                if (child == preNode) return node;
                preNode = node;
                node = node.parent;
            }
            return null;
        }

        public enum WalkType {inorder,preorder,postorder}
        public int[] allValue(boolean recursion,WalkType type) {
            int[] output = new int[count()];
            IntObject zero = new IntObject(0);
            if (recursion) traversal(output, zero,type);
            else traversalWithNoRecursion(output, zero,type);
            return output;
        }

        private void traversalWithNoRecursion(int[] output, IntObject index,WalkType type) {
            if (type == WalkType.preorder) preOrder(output,index);
            else if (type == WalkType.inorder) inOrder(output,index);
        }
        private void preOrder(int[] output, IntObject index) {
            BinaryTree[] bt = new BinaryTree[output.length];
            Stack<BinaryTree> stack = new Stack(bt);
            BinaryTree node = this;
            stack.push(node);
            while (stack.hasNext()) {
                node = stack.pop();
                assign(output,index,node.key);
                if (node.rightChild != null) stack.push(node.rightChild);
                if (node.leftChild != null) stack.push(node.leftChild);
            }
        }
        private void inOrder(int[] output,IntObject index) {
            BinaryTree[] bt = new BinaryTree[output.length];
            Stack<BinaryTree> stack = new Stack(bt);
            BinaryTree node = this;
            boolean isPoped = false;
            while (true) {
                if (node.leftChild != null && isPoped == false)
                {
                    stack.push(node);
                    node = node.leftChild;
                }
                else
                {
                    assign(output,index,node.key);
                    if (node.rightChild != null) {
                        node = node.rightChild; isPoped = false;
                    }else {
                        node = stack.pop();
                        if (node == null) return;
                        isPoped = true;
                    }
                }
            }
        }

        private void traversal(int[] output, IntObject index, WalkType type) {
            if (type == WalkType.preorder) assign(output,index,key);
            if (leftChild != null) leftChild.traversal(output, index, type);
            if (type == WalkType.inorder) assign(output,index,key);
            if (rightChild != null) rightChild.traversal(output, index, type);
            if (type == WalkType.postorder) assign(output,index,key);
        }
        private void assign(int[] output,IntObject index,int value) {
            output[index.raw] = value;
            index.add(1);
        }

        public int count() {
            int count = 1;
            if (leftChild != null) count += leftChild.count();
            if (rightChild != null) count += rightChild.count();
            return count;
        }

        public BinaryTree find_Recursion(int key) {
            if (key == this.key) return this;
            else if (key < this.key && this.leftChild != null)
                return this.leftChild.find_Recursion(key);
            else if (key > this.key && this.rightChild != null)
                return this.rightChild.find_Recursion(key);
            return null;
        }
        public BinaryTree find(int key) {
            BinaryTree target = this;
            while (target != null && key != target.key) {
                if (key < target.key)
                    target = target.leftChild;
                else target = target.rightChild;
            }
            return target;
        }
    }


}
