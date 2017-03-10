# `CLRS` 练习
**InsertionSort:**

```java
  int[] seq = {10,4,5};
  InsertionSort is = new InsertionSort(seq,InsertionSort.InsertionSortType.ascending);
  System.out.println(Arrays.toString(is.sort()));
```
**LineQuery:**

```java
	int[] A = {1,4,6,13};
	int v = 6;
	LineQuery lq = new LineQuery(A,v);
	System.out.println(lq.query());
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