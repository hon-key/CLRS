# `CLRS` 练习
**InsertionSort:**

```java
 	int[] seq = {10,4,5};
 	InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
  	System.out.println(Arrays.toString(is.sort()));
  	System.out.println("InsertionSortWithRecursion: " + Arrays.toString(is.sortWithRecursion()));
```
**LineQuery:**

```java
	int[] lq_A = {1,4,6,13};
  	int v = 6;
	LineQuery lq = new LineQuery(lq_A,v);
	System.out.println("lineQuery: " + lq.query());
  	int[] lq_B = {1,2,3,14};
 	int v_d = 16;
  	LineQuery lq_d = new LineQuery(lq_B,v_d);
	System.out.println("dichotomy: " + lq_d.queryWithDichotomy());
```

**BinaryAddition**

```java
	int[] _A = {1,1,0,1,1,0,1,1,1,0};
 	int[] B = {1,0,0,0,1,0,0,1,0,1};
   	BinaryAddition ba = BinaryAddition.create(_A,B);
   	ba.add();
   	System.out.println(Arrays.toString(ba.A));
   	System.out.println(Arrays.toString(ba.B));
   	System.out.println(Arrays.toString(ba.C));
```
**SelectionSort**

```java
	int[] ss_A = {1,4,7,9,10,3,20,8,3,2,4,4};
   	SelectionSort ss = new SelectionSort(ss_A);
	System.out.println(Arrays.toString(ss_A));
	System.out.println(Arrays.toString(ss.sort()));
```

**MergeSort**

```java
	int[] ms_A = {6,5,4,3,2,7};
  	MergeSort ms = new MergeSort(ms_A);
 	System.out.println("MergeSort: ");
 	System.out.println(Arrays.toString(ms_A));
  	System.out.println(Arrays.toString(ms.sort(false)));
	System.out.println("Inversion: " + ms.inversion);
```

**BubbleSort**

```java
	int[] bs_A = {1,4,2,9,5,18,15,17,12};
	BubbleSort bs = new BubbleSort(bs_A);
	System.out.println("BubbleSort: ");
	System.out.println(Arrays.toString(bs_A));
	System.out.println(Arrays.toString(bs.sort()));
```

**Horner**

```java
	int[] hornerA = {20,20,3,6,9,12};
	int x = 8;
  	Horner h = new Horner(hornerA,x);
 	System.out.println("Horner: ");
  	System.out.println("Normal: " + h.normalCal());
  	System.out.println("Special: " + h.specialCal());
```

**FindMaximumSubArray**

```java
	int[] fmsa_B = {0,1,-5,6};
 	FindMaximumSubArray.SubSeq recursion = FindMaximumSubArray.recursionFind(fmsa_B);
  	FindMaximumSubArray.SubSeq violentFind = FindMaximumSubArray.violentFind(fmsa_B);
 	FindMaximumSubArray.SubSeq lineFind = FindMaximumSubArray.LinearFind(fmsa_B);
 	System.out.println("FindMaximumSubArray: ");
 	System.out.println(Arrays.toString(fmsa_A));
	System.out.println("recursion: [low: " + recursion.low + ", high: " + recursion.high + ", sum: " + recursion.sum + "]");
 	System.out.println("violentFind: [low: " + violentFind.low + ", high: " + violentFind.high + ", sum: " + violentFind.sum + "]") ;
 	System.out.println("lineFind: [low: " + lineFind.low + ", high: " + lineFind.high + ", sum: " + lineFind.sum + "]");
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
  		System.out.println(Arrays.toString(strassen[i]));
  	}
```

**HireAssistant**

```java
	HireAssistant hire = new HireAssistant();
 	System.out.println("HireAssistant: ");
  	System.out.println("Directly: ");
  	hire.hireDirectly(1,2,3,4,5);
  	System.out.println("Randomly: ");
  	hire.hireRandomly(1,2,3,4,5);
```