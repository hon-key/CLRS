
为了方便显示，我们假定拥有以下函数以供调用：

```java
	public static void print(int[] seq) {
 		System.out.println(Arrays.toString(seq));
 	}
 	public static void print(double[] seq) {
		System.out.println(Arrays.toString(seq));
  	}
 	public static void print(int val) {
 		System.out.println(val);
  	}
	public static void print(String str) {
		System.out.println(str);
  	}
```

# SORT
**InsertionSort:**

```java
 	int[] seq = {10,4,5};
 	InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
  	print(is.sort());
  	print("InsertionSortWithRecursion: " + is.sortWithRecursion());
```
**LinearQuery:**

```java
	int[] lq_A = {1,4,6,13};
  	int v = 6;
	LineQuery lq = new LineQuery(lq_A,v);
	print("lineQuery: " + lq.query());
  	int[] lq_B = {1,2,3,14};
 	int v_d = 16;
  	LineQuery lq_d = new LineQuery(lq_B,v_d);
	print("dichotomy: " + lq_d.queryWithDichotomy());
```

**BinaryAddition**

```java
	int[] _A = {1,1,0,1,1,0,1,1,1,0};
 	int[] B = {1,0,0,0,1,0,0,1,0,1};
   	BinaryAddition ba = BinaryAddition.create(_A,B);
   	ba.add();
   print(ba.A);
   	print(ba.B);
   	print(ba.C);
```
**SelectionSort**

```java
	int[] ss_A = {1,4,7,9,10,3,20,8,3,2,4,4};
   	SelectionSort ss = new SelectionSort(ss_A);
	print(ss_A);
	print(ss.sort());
```

**MergeSort**

```java
	int[] ms_A = {6,5,4,3,2,7};
  	MergeSort ms = new MergeSort(ms_A);
 	print("MergeSort: ");
 	print(ms_A);
  	print(ms.sort(false));
	print("Inversion: " + ms.inversion);
```

**BubbleSort**

```java
	int[] bs_A = {1,4,2,9,5,18,15,17,12};
	BubbleSort bs = new BubbleSort(bs_A);
	print("BubbleSort: ");
	print(bs_A);
	print(bs.sort());
```

**Horner**

```java
	int[] hornerA = {20,20,3,6,9,12};
	int x = 8;
  	Horner h = new Horner(hornerA,x);
 	print("Horner: ");
  	print("Normal: " + h.normalCal());
  	print("Special: " + h.specialCal());
```

**FindMaximumSubArray**

```java
	int[] fmsa_B = {0,1,-5,6};
 	FindMaximumSubArray.SubSeq recursion = FindMaximumSubArray.recursionFind(fmsa_B);
  	FindMaximumSubArray.SubSeq violentFind = FindMaximumSubArray.violentFind(fmsa_B);
 	FindMaximumSubArray.SubSeq lineFind = FindMaximumSubArray.LinearFind(fmsa_B);
 	print("FindMaximumSubArray: ");
 	print(fmsa_A);
	print("recursion: [low: " + recursion.low + ", high: " + recursion.high + ", sum: " + recursion.sum + "]");
 	print("violentFind: [low: " + violentFind.low + ", high: " + violentFind.high + ", sum: " + violentFind.sum + "]") ;
 	print("lineFind: [low: " + lineFind.low + ", high: " + lineFind.high + ", sum: " + lineFind.sum + "]");
```

**Strassen**
<br><font face = "Sans-serif" color = "Gray">Square-Matrix-Multyply-Recursive</font>

```java
	int[][] mA = {
	{1,1,1,1},
	{1,1,1,1},
	{1,1,1,1},
	{2,10,1,5}
 	};
 	int[][] mB = {
 	{1,1,1,1},
 	{1,1,1,1},
 	{1,1,1,1},
 	{1,1,1,1}
 	};
	int[][] strassen = SquareMatrixMultiply.multi(mA,mB);
 	for (int i = 0; i < strassen.length; i++) {
  		print(strassen[i]);
  	}
```

**HireAssistant**

```java
	HireAssistant hire = new HireAssistant();
 	print("HireAssistant: ");
  	print("Directly: ");
  	hire.hireDirectly(1,2,3,4,5);
  	print("Randomly: ");
  	hire.hireRandomly(1,2,3,4,5);
```

**HeapSort**

```java
	int[] hps_A = {6,1,5,3,2,4};
 	print("HeapSort: ");
  	print(hps_A);
  	HeapSort.sort(hps_A);
  	print(hps_A);
```

**PriorityQueue**

```java
	int[] pq_A = {1,3,2,5,4};
	PriorityQueue pq = new PriorityQueue(pq_A);
  	print("PriorityQueue:");
  	System.out.print("Raws:"); pq.printRaw();
  	System.out.print("Heap:"); pq.printHeap();
  	print("Maximum:" + pq.maximum());
  	pq.extractMax();
  	System.out.print("ExtractMax:");pq.printHeap();
  	pq.insert(10);
  	System.out.print("Insert:");pq.printHeap();
  	pq.increaseKey(1,15);
  	System.out.print("IncreseKey:");pq.printHeap();
```

**QuickSort**

```java
	int[] qs_A = {3,7,6,5,4,4};
	print("QuickSort:");
	print(qs_A);
 	QuickSort.isAscending = false;
 	QuickSort.sort(qs_A);
	print(qs_A);
```

**CountingSort**

```java
	int[] cs_A = {6,8,4,2,2,1,4,7,5,13,16,18,20,14,15};
 	int[] cs_B = CountingSort.sort(cs_A);
 	print("CountingSort:");
 	print(cs_A);
 	print(cs_B);
```

**RadixSort**

```java
	String[] rs_A = {"Irelia","Trundle","Ezreal","Alistar",
                "Garen","Graves","Jayce","Katarina",
                "LeBlanc","lulu","Lux"};
	String[] rs_B = RadixSort.sort(rs_A);
	for (String str : rs_B) {
  		print("[" + str + "]");
	}
```

**BucketSort**

```java
	double[] bucket_A = {0.14,0.13,0.2,0.11,0.99,0.88,0.7,0.6,0.5,0.4,0.3,0.2,0.1,0.898,0.875};
	double[][]bucket_B = BucketSort.sort(bucket_A);
	for (double[] list : bucket_B) {
		print(list);
	}
```

**RandomizeSelect**

```java
	int[] randomizeSelect_A = {1,3,4,2};
	int val = RandomizedSelect.select(randomizeSelect_A,2);	
	print(randomizeSelect_A);
	print(val);
```

# Data structure

**Stack**

```java
	print("Stack:");
	Integer[] array = new Integer[100];
 	Stack<Integer> stack = new Stack(array);
 	stack.push(3);stack.push(4);stack.push(5);
 	stack.push(8);stack.push(20);
  	stack.pop();
	ArrayList<Integer> raw = stack.raw();
 	for (Integer integer : raw)
  		System.out.print(integer.intValue() + ",");
 	print("");
```

**Queue**

```java
	print("Queue:");
	Queue queue = new Queue(50);
	queue.in(3);queue.in(4);queue.in(5);
	queue.out();
	print(queue.raw());
```

**Linklist**

```java
	print("LinkList:");
	LinkList head = new LinkList(LinkList.head,null);
 	Random r = new Random();
  	LinkList node = head;
 	for (int i = 0; i < 10; i++) {
  		node.next = new LinkList(r.nextInt(100), null);
 		node = node.next;
     	System.out.print("[+" + node.value + "]");
 	}
  	print("");
 	print(head.array());
```

**BinaryTree**

```java
	print("BinaryTree:");
  	Tree.BinaryTree root = new Tree.BinaryTree(100);
 	root.setLeftChild(new Tree.BinaryTree(50));
 	root.setRightChild(new Tree.BinaryTree(110));
  	root.leftChild.setLeftChild(new Tree.BinaryTree(35));
  	root.leftChild.leftChild.setRightChild(new Tree.BinaryTree(40));
 	root.leftChild.leftChild.rightChild.setLeftChild(new Tree.BinaryTree(37));
	root.leftChild.leftChild.rightChild.setRightChild(new Tree.BinaryTree(45));
	root.rightChild.setRightChild(new Tree.BinaryTree(150));
	root.rightChild.setLeftChild(new Tree.BinaryTree(105));
	print(root.allValue(true, Tree.BinaryTree.WalkType.inorder));
	print(root.find(105).key);
 	print(root.maximum_Recursion().key);
 	print(root.rightChild.rightChild.predecessor().key);
  	root.insert(new Tree.BinaryTree(60));
  	root.insert_recursion(new Tree.BinaryTree(160));
  	print(root.allValue(true, Tree.BinaryTree.WalkType.inorder));
  	Tree.BinaryTree del = root.find(105);
   	root.deleteFromTree();
 	print(del.allValue(true, Tree.BinaryTree.WalkType.inorder));
```

**RedBlackTree**

```java
	print("RedBlackTree:");
	Tree.RedBlackTree rbroot = new Tree.RedBlackTree(100);
 	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(20));
 	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(21));
	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(150));
 	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(89));
 	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(201));
 	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(12));
	rbroot = (Tree.RedBlackTree) rbroot.insert(new Tree.RedBlackTree(101));
  	print(rbroot.allValue(true, Tree.BinaryTree.WalkType.inorder));
  	rbroot.find(201).deleteFromTree();
  	rbroot.find(12).deleteFromTree();
 	print(rbroot.allValue(true, Tree.BinaryTree.WalkType.inorder));
```

**OrderStaticTree**

```java
	print("OrderStaticTree:");
  	Tree.OrderStaticTree OSRoot = new Tree.OrderStaticTree(999);
  	OSRoot = (Tree.OrderStaticTree) OSRoot.insert(new Tree.OrderStaticTree(80));
  	OSRoot = (Tree.OrderStaticTree) OSRoot.insert(new Tree.OrderStaticTree(1004));
  	OSRoot = (Tree.OrderStaticTree) OSRoot.insert(new Tree.OrderStaticTree(99));
 	OSRoot = (Tree.OrderStaticTree) OSRoot.insert(new Tree.OrderStaticTree(200));
	OSRoot = (Tree.OrderStaticTree) OSRoot.insert(new Tree.OrderStaticTree(50));
  	OSRoot = (Tree.OrderStaticTree) OSRoot.insert(new Tree.OrderStaticTree(44));
 	print(OSRoot.allValue(true, Tree.BinaryTree.WalkType.inorder));
 	Tree.OrderStaticTree t = (Tree.OrderStaticTree) OSRoot.find(44);
	print(t.rank());
 	t = (Tree.OrderStaticTree) OSRoot.find(1004);
  	print(t.rank());
  	print(OSRoot.select(0).key);
  	print(OSRoot.select(10).key);
```

**CutRod**

```java
 	print("CutRod:");
 	int[] price = {1,5,8,9,10,17,17,20,24,30};
	print(CutRod.cut(price,10));
	CutRod.cut_memoized(price,7).printSolution();
 	CutRod.cut_bottom_up(price,7).printSolution();
 	System.out.println(997.0/1000.0);
```

**Gauss and Cholesky and QR**

```java
	print("Gauss:");
 	double[][] Gauss_R = {
    	{1,4,7},
  		{2,5,8},
   		{3,6,10}
	};
 	Matrix Gauss_A = Matrix.create(Gauss_R);
  	Gauss_A = GaussianElimination.Eliminate(Gauss_A);
  	Gauss_A.print();
	
	print("Cholesky:");
 	double[][] Cholesky_R = {
   		{4,-2,4,2},
    	{-2,10,-2,-7},
      	{4,-2,8,4},
    	{2,-7,4,7}
	};
  	Matrix Cholesky_A = Matrix.create(Cholesky_R);
 	Cholesky_A = CholeskyFactorization.Eliminate(Cholesky_A);
 	Cholesky_A.print();

	print("QR:");
	double[][] QR_A = {
  		{4,-2,4,2},
     	{-2,10,-2,-7},
    	{4,-2,8,4},
 		{2,-7,4,7},
     	{8,-5,3,13}
  	};
   	Matrix QR_M = Matrix.create(QR_A);
	Householder.House[] houses = QRDecomposition.decompose(QR_M);
   	QR_M.print();
```

**MatrixChainOrder**

```java
  	MatrixChainOrder.Result re = MatrixChainOrder.cal(30,35,15,5,10,20,25);
  	re.printOptimalParens(1,re.n);
 	print(re.m.get(2,5));
  	MatrixChainOrder.Result re2 = MatrixChainOrder.memoizedCal(30,35,15,5,10,20,25);
  	re2.printOptimalParens(1,re2.n);
  	print(re2.m.get(2,5));
```

**LCS**

求最长公共子序列，属于求最优解问题，该问题适合使用动态规划来解决。

动态规划类似于分治法，需要将问题分割为多个子问题进行求解。然而分治法只关注问题的分割，没有关注重复计算的问题，有可能导致相同子问题大量重复计算

动态规划也将问题分为多个子问题，但是，它会选择缓存子问题的结果，重复计算问题得到解决

对于求最长公共子序列，其属于求最优解问题，且可以分割为子问题，所以可以使用动态规划来解决

其子问题可以归结为：

<img src="https://github.com/hon-key/CLRS/blob/master/3.png" width = "100%" />

<img src="https://github.com/hon-key/CLRS/blob/master/1.png" width = "100%" />

<img src="https://github.com/hon-key/CLRS/blob/master/2.png" width = "100%" />


```java
	print("LCS:");
 	String[] LCS_X = {"A","B","C","B","D","A","B"};
  	String[] LCS_Y = {"B","D","C","A","B","A"};
	LCS.Result LCS_re = LCS.getLCS(LCS_X,LCS_Y);
  	LCS_re.printLCS();
```

**OptimalBST**

```java
	print("OptimalBST:");
 	double[] p = {0,0.15,0.10,0.05,0.10,0.20};
  	double[] q = {0.05,0.10,0.05,0.05,0.05,0.10};
	OptimalBST.Result OBST_re = OptimalBST.cal(p,q);
 	OBST_re.printOptimalBST();
```
