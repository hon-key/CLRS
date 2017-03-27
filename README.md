
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
 	for (int i = 0; i < result.length; i++) {
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
	Stack stack = new Stack(100);
  	stack.push(3);stack.push(4);stack.push(5);
 	stack.push(8);stack.push(20);
 	stack.pop();
  	print(stack.raw());
```

**Queue**

```java
	print("Queue:");
	Queue queue = new Queue(50);
	queue.in(3);queue.in(4);queue.in(5);
	queue.out();
	print(queue.raw());
```