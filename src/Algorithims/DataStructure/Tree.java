package Algorithims.DataStructure;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.print.attribute.standard.OrientationRequested;

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
            int minKey = firstRightAncestor != nil() ? firstRightAncestor.key : Integer.MIN_VALUE;
            if (leftChild.key >= minKey && leftChild.key <= maxKey) {
                this.leftChild = leftChild;
                leftChild.parent = this;
            }else throw new Exception("插入左孩子的值有误，需要在" + minKey + " - " + maxKey + "之间");
        }
        public void setRightChild(BinaryTree rightChild) throws Exception {
            int minKey = this.key;
            BinaryTree firstLeftAncestor = findFirstAncestor(AncestorType.leftAncestor);
            int maxKey = firstLeftAncestor != nil() ? firstLeftAncestor.key : Integer.MAX_VALUE;
            if (rightChild.key >= minKey && rightChild.key <= maxKey) {
                this.rightChild = rightChild;
                rightChild.parent = this;
            }else throw new Exception("插入右孩子的值有误，需要在" + minKey + " - " + maxKey + "之间");
        }
        private enum AncestorType {rightAncestor,leftAncestor}
        private BinaryTree findFirstAncestor(AncestorType type) {
            BinaryTree node = this.parent;
            BinaryTree preNode = this;
            while (node != nil()) {
                BinaryTree child = type == AncestorType.rightAncestor ? node.rightChild : node.leftChild;
                if (child == preNode) return node;
                preNode = node;
                node = node.parent;
            }
            return nil();
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
                if (node.rightChild != nil()) stack.push(node.rightChild);
                if (node.leftChild != nil()) stack.push(node.leftChild);
            }
        }
        private void inOrder(int[] output,IntObject index) {
            BinaryTree[] bt = new BinaryTree[output.length];
            Stack<BinaryTree> stack = new Stack(bt);
            BinaryTree node = this;
            boolean isPoped = false;
            while (true) {
                if (node.leftChild != nil() && isPoped == false)
                {
                    stack.push(node);
                    node = node.leftChild;
                }
                else
                {
                    assign(output,index,node.key);
                    if (node.rightChild != nil()) {
                        node = node.rightChild; isPoped = false;
                    }else {
                        node = stack.pop();
                        if (node == nil()) return;
                        isPoped = true;
                    }
                }
            }
        }

        private void traversal(int[] output, IntObject index, WalkType type) {
            if (type == WalkType.preorder) assign(output,index,key);
            if (leftChild != nil()) leftChild.traversal(output, index, type);
            if (type == WalkType.inorder) assign(output,index,key);
            if (rightChild != nil()) rightChild.traversal(output, index, type);
            if (type == WalkType.postorder) assign(output,index,key);
        }
        private void assign(int[] output,IntObject index,int value) {
            output[index.raw] = value;
            index.add(1);
        }

        public int count() {
            int count = 1;
            if (leftChild != nil()) count += leftChild.count();
            if (rightChild != nil()) count += rightChild.count();
            return count;
        }

        public BinaryTree find_Recursion(int key) {
            if (key == this.key) return this;
            else if (key < this.key && this.leftChild != nil())
                return this.leftChild.find_Recursion(key);
            else if (key > this.key && this.rightChild != nil())
                return this.rightChild.find_Recursion(key);
            return nil();
        }
        public BinaryTree find(int key) {
            BinaryTree target = this;
            while (target != nil() && key != target.key) {
                if (key < target.key)
                    target = target.leftChild;
                else target = target.rightChild;
            }
            return target;
        }
        public BinaryTree minimum() {
            BinaryTree node = this;
            while (node.leftChild != nil())
                node = node.leftChild;
            return node;
        }
        public BinaryTree minimum_Recursion() {
            BinaryTree node = this;
            if (node.leftChild != nil()) return node.leftChild.minimum_Recursion();
            return node;
        }
        public BinaryTree maximum() {
            BinaryTree node = this;
            while (node.rightChild != nil())
                node = node.rightChild;
            return node;
        }
        public BinaryTree maximum_Recursion() {
            BinaryTree node = this;
            if (node.rightChild != nil()) return node.rightChild.maximum_Recursion();
            return node;
        }
        public BinaryTree successor() {
            BinaryTree node = this;
            if (node.rightChild != nil())
                return node.rightChild.minimum();
            BinaryTree nodeParent = node.parent;
            while (nodeParent != nil() && node == nodeParent.rightChild) {
                node = nodeParent;
                nodeParent = node.parent;
            }
            return nodeParent;
        }
        public BinaryTree predecessor() {
            BinaryTree node = this;
            if (node.leftChild != nil())
                return node.leftChild.maximum();
            BinaryTree nodeParent = node.parent;
            while (nodeParent != nil() && node == nodeParent.leftChild) {
                node = nodeParent;
                nodeParent = node.parent;
            }
            return nodeParent;
        }

        public BinaryTree insert(BinaryTree target) throws Exception {
            if (this.parent != nil()) throw new Exception("接受插入的节点不是Root节点。");
            BinaryTree leaf = nil();
            BinaryTree node = this;
            while (node != nil()) {
                leaf = node;
                if (target.key < node.key)
                    node = node.leftChild;
                else node = node.rightChild;
            }
            target.parent = leaf;
            if (target.key < leaf.key)
                leaf.leftChild = target;
            else leaf.rightChild = target;
            return this;
        }
        public void insert_recursion(BinaryTree target) throws Exception  {
            if (this.parent != nil()) throw new Exception("接受插入的节点不是Root节点。");
            recursion(target);
        }
        private void recursion(BinaryTree target) {
            if (target.key <= this.key) {
                if (this.leftChild != nil()) this.leftChild.recursion(target);
                else {this.leftChild = target;target.parent = this;}
            }else if ( target.key > this.key) {
                if (this.rightChild != nil()) this.rightChild.recursion(target);
                else {this.rightChild = target;target.parent = this;}
            }
        }

        public void deleteFromTree() {
            if (this.leftChild == nil())
                transplant(this.rightChild);
            else if (this.rightChild == nil())
                transplant(this.leftChild);
            else {
                BinaryTree successor = successor();
                if (successor.parent != this) {
                    successor.transplant(successor.rightChild);
                    successor.rightChild = this.rightChild;
                    successor.rightChild.parent = successor;
                }
                transplant(successor);
                successor.leftChild = this.leftChild;
                successor.leftChild.parent = this;
            }
        }

        public void transplant(BinaryTree target) {
            if (this.parent == nil()) return;
            else if (this.parent.leftChild == this)
                this.parent.leftChild = target;
            else this.parent.rightChild = target;
            if (target != nil())
                target.parent = this.parent;
        }
        public BinaryTree getRoot() {
            BinaryTree node = this;
            while (node.parent != nil())
                node = node.parent;
            return node;
        }

        protected BinaryTree nil() { return null;}

    }



    public static class RedBlackTree extends BinaryTree {
        public static final RedBlackTree nil = new RedBlackTree(Color.black,-1);

        public enum Color {red,black}
        protected Color color;

        public Color getColor() { return color;}

        public RedBlackTree(int value) {
            super(value);
            parent = rightChild = leftChild = nil();
        }
        protected RedBlackTree(Color color,int value) {
            super(value);
            this.color = color;
        }

        public void leftRotate() {
            if (this.rightChild == nil()) return;
            RedBlackTree y = (RedBlackTree)this.rightChild;
            this.rightChild = y.leftChild;
            if (this.rightChild != nil())
                this.rightChild.parent = this;
            y.parent = this.parent;
            if (this == this.parent.leftChild)
                this.parent.leftChild = y;
            else if (this == this.parent.rightChild)
                this.parent.rightChild = y;
            y.leftChild = this;
            this.parent = y;
        }
        public void rightRotate() {
            if (this.leftChild == nil()) return;
            RedBlackTree y = (RedBlackTree)this.leftChild;
            this.leftChild = y.rightChild;
            if (this.leftChild != nil())
                this.leftChild.parent = this;
            y.parent = this.parent;
            if (this == this.parent.leftChild)
                this.parent.leftChild = y;
            else if (this == this.parent.rightChild)
                this.parent.rightChild = y;
            y.rightChild = this;
            this.parent = y;
        }

        @Override
        public void insert_recursion(BinaryTree target) throws Exception {return;}
        @Override
        public BinaryTree insert(BinaryTree target) throws Exception {
            if (!(target instanceof RedBlackTree)) throw new Exception("接受参数只能是RedBlackTree.Node类型.");
            super.insert(target);
            target.leftChild = nil();
            target.rightChild = nil();
            ((RedBlackTree)target).color = Color.red;
            return insertFixUp((RedBlackTree)target);
        }
        protected RedBlackTree insertFixUp(RedBlackTree target) {
            while (((RedBlackTree)target.parent).color == Color.red) {
                if (target.parent == target.parent.parent.leftChild)
                    target = fixUp(target,true);
                else target = fixUp(target,false);
            }
            RedBlackTree root = (RedBlackTree)getRoot();
            root.color = Color.black;
            return root;
        }

        private RedBlackTree fixUp(RedBlackTree target,boolean isLeft)
        {
            RedBlackTree uncle = isLeft ?
                    (RedBlackTree)target.parent.parent.rightChild:
                    (RedBlackTree)target.parent.parent.leftChild;

            if (uncle.color == Color.red) return condition1(target,uncle);

            else if (target == (isLeft ? target.parent.rightChild : target.parent.leftChild))
                target = condition2(target,isLeft);

            condition3(target,isLeft);

            return target;
        }

        private RedBlackTree condition1(RedBlackTree target,RedBlackTree uncle) {
            ((RedBlackTree) target.parent).color = Color.black;
            uncle.color = Color.black;
            ((RedBlackTree)uncle.parent).color = Color.red;
            return (RedBlackTree) target.parent.parent;
        }
        private RedBlackTree condition2(RedBlackTree target,boolean isLeft) {
            target = (RedBlackTree) target.parent;
            if (isLeft) target.leftRotate();
            else target.rightRotate();
            return target;
        }
        private void condition3(RedBlackTree target,boolean isLeft) {
            ((RedBlackTree) target.parent).color = Color.black;
            ((RedBlackTree)target.parent.parent).color = Color.red;
            if (isLeft) ((RedBlackTree) target.parent.parent).rightRotate();
            else ((RedBlackTree) target.parent.parent).leftRotate();
        }



        public void RB_transplant(RedBlackTree target) {
            super.transplant(target);
            target.parent = this.parent;
        }

        @Override
        public void deleteFromTree() {
            RedBlackTree y = this;
            RedBlackTree x;
            Color y_original_color = y.color;
            if (this.leftChild == nil()) {
                x = (RedBlackTree) this.rightChild;
                this.RB_transplant(x);
            }else if (this.rightChild == nil()) {
                x = (RedBlackTree) this.leftChild;
                this.RB_transplant(x);
            }else {
                y = (RedBlackTree) successor();
                y_original_color = y.color;
                x = (RedBlackTree) y.rightChild;
                if (y.parent == this)
                    x.parent = y;
                else {
                    y.RB_transplant(x);
                    y.rightChild = this.rightChild;
                    y.rightChild.parent = y;
                }
                this.RB_transplant(y);
                y.leftChild = this.leftChild;
                y.leftChild.parent = y;
                y.color = this.color;
            }
            if (y_original_color == Color.black)
                deleteFixUp(x);
            this.parent = nil();
            this.leftChild = nil();
            this.rightChild = nil();
        }

        protected void deleteFixUp(RedBlackTree target)
        {
            RedBlackTree root = (RedBlackTree) getRoot();

            while (target != root && target.color == Color.black) {

                if (target == target.parent.leftChild)
                    target = deleteFixUp(target,true);

                else target = deleteFixUp(target,false);
            }

            target.color = Color.black;
        }
        private RedBlackTree deleteFixUp(RedBlackTree target,boolean isLeft)
        {
            RedBlackTree brother = isLeft ? (RedBlackTree) target.parent.rightChild :
                                      (RedBlackTree) target.parent.leftChild;

            if (brother.color == Color.red) brother = case1(target,brother,isLeft);

            RedBlackTree brother_child1 = isLeft ? (RedBlackTree)brother.leftChild : (RedBlackTree)brother.rightChild;
            RedBlackTree brother_child2 = isLeft ? (RedBlackTree)brother.rightChild : (RedBlackTree)brother.leftChild;

            if (brother_child1.color == Color.black && brother_child2.color == Color.black)
                return case2(target,brother);

            if (brother_child2.color == Color.black) brother = case3(target,brother,isLeft);

            return case4(target,brother,isLeft);
        }
        private RedBlackTree case1(RedBlackTree target,RedBlackTree brother,boolean isLeft) {
            brother.color = Color.black;
            ((RedBlackTree)target.parent).color = Color.red;
            if (isLeft)
                ((RedBlackTree) target.parent).leftRotate();
            else ((RedBlackTree) target.parent).rightRotate();
            brother = isLeft ? (RedBlackTree) target.parent.rightChild :
                    (RedBlackTree) target.parent.leftChild;
            return brother;
        }
        private RedBlackTree case2(RedBlackTree target,RedBlackTree brother) {
            brother.color = Color.red;
            target = (RedBlackTree) target.parent;
            return target;
        }
        private RedBlackTree case3(RedBlackTree target,RedBlackTree brother,boolean isLeft) {
            RedBlackTree brother_child1 = isLeft ? (RedBlackTree)brother.leftChild : (RedBlackTree)brother.rightChild;
            brother_child1.color = Color.black;
            brother.color = Color.red;
            if (isLeft) brother.rightRotate();
            else brother.leftRotate();
            brother = isLeft ? (RedBlackTree) target.parent.rightChild :
                    (RedBlackTree) target.parent.leftChild;
            return brother;
        }
        private RedBlackTree case4(RedBlackTree target,RedBlackTree brother,boolean isLeft) {
            brother.color = ((RedBlackTree)target.parent).color;
            ((RedBlackTree) target.parent).color = Color.black;
            if (isLeft){
                ((RedBlackTree) brother.rightChild).color = Color.black;
                ((RedBlackTree) target.parent).leftRotate();
            }
            else {
                ((RedBlackTree) brother.leftChild).color = Color.black;
                ((RedBlackTree) target.parent).rightRotate();
            }
            return (RedBlackTree) getRoot();
        }

        @Override
        protected BinaryTree nil() {return nil;}

    }

    public static class OrderStaticTree extends RedBlackTree {
        public static final OrderStaticTree nil = new OrderStaticTree(-1,0);
        public int size;
        public OrderStaticTree(int value) {
            super(value); size = 1;
        }
        private OrderStaticTree(int value,int size) {
            super(Color.black,value); this.size = size;
        }

        public OrderStaticTree select(int i) throws Exception {
            i++;
            if (this.size == 0)
                throw new Exception("参数 " + i + " 超出了范围");
            int r = ((OrderStaticTree)this.leftChild).size + 1;
            if (i == r)
                return this;
            else if (i < r)
                return ((OrderStaticTree) this.leftChild).select(--i);
            else return ((OrderStaticTree) this.rightChild).select((--i)-r);
        }
        public int rank() {
            int r = ((OrderStaticTree)this.leftChild).size + 1;
            OrderStaticTree y = this;
            OrderStaticTree root = (OrderStaticTree) getRoot();
            while (y != root) {
                if (y == y.parent.rightChild)
                    r = r + ((OrderStaticTree)y.parent.leftChild).size + 1;
                y = (OrderStaticTree) y.parent;
            }
            return r;
        }

        @Override
        public BinaryTree insert(BinaryTree target) throws Exception {
            if (!(target instanceof OrderStaticTree)) throw new Exception("接受参数只能是OrderStaticTree类型.");
            insert_OrderStaticTreeVersion((OrderStaticTree) target);
            target.leftChild = nil();
            target.rightChild = nil();
            ((OrderStaticTree)target).color = Color.red;
            ((OrderStaticTree) target).size = 1;
            return insertFixUp((RedBlackTree)target);
        }

        private OrderStaticTree insert_OrderStaticTreeVersion(OrderStaticTree target) throws Exception {
            if (this.parent != nil()) throw new Exception("接受插入的节点不是Root节点。");
            OrderStaticTree leaf = (OrderStaticTree) nil();
            OrderStaticTree node = this;
            while (node != nil()) {
                leaf = node;
                node.size++;
                if (target.key < node.key)
                    node = (OrderStaticTree) node.leftChild;
                else node = (OrderStaticTree) node.rightChild;
            }
            target.parent = leaf;
            if (target.key < leaf.key)
                leaf.leftChild = target;
            else leaf.rightChild = target;
            return this;
        }
        @Override
        public void leftRotate() {
            OrderStaticTree x = this;
            super.leftRotate();
            ((OrderStaticTree)this.parent).size = this.size;
            this.size = ((OrderStaticTree)this.leftChild).size +
                    ((OrderStaticTree) this.rightChild).size + 1;
        }
        @Override
        public void rightRotate() {
            super.rightRotate();
            ((OrderStaticTree)this.parent).size = this.size;
            this.size = ((OrderStaticTree) this.leftChild).size +
                    ((OrderStaticTree)this.rightChild).size + 1;
        }

        @Override
        public void deleteFromTree() {
            RedBlackTree y = this;
            RedBlackTree x;
            Color y_original_color = y.color;
            if (this.leftChild == nil()) {
                x = (RedBlackTree) this.rightChild;
                sizeDecreaseUpToRoot((OrderStaticTree) y);
                this.RB_transplant(x);
            }else if (this.rightChild == nil()) {
                x = (RedBlackTree) this.leftChild;
                sizeDecreaseUpToRoot((OrderStaticTree) y);
                this.RB_transplant(x);
            }else {
                y = (RedBlackTree) successor();
                y_original_color = y.color;
                x = (RedBlackTree) y.rightChild;
                sizeDecreaseUpToRoot((OrderStaticTree) y);
                if (y.parent == this)
                    x.parent = y;
                else {
                    y.RB_transplant(x);
                    y.rightChild = this.rightChild;
                    y.rightChild.parent = y;
                }
                this.RB_transplant(y);
                y.leftChild = this.leftChild;
                y.leftChild.parent = y;
                y.color = this.color;
                ((OrderStaticTree)y).size = this.size;
            }
            if (y_original_color == Color.black)
                deleteFixUp(x);
            this.parent = nil();
            this.leftChild = nil();
            this.rightChild = nil();
        }

        private void sizeDecreaseUpToRoot(OrderStaticTree target) {
            if (target == nil()) return;
            while (target != nil()) {
                target.size--;
                target = (OrderStaticTree) target.parent;
            }
        }

        @Override
        protected BinaryTree nil() { return nil;}
    }


}
