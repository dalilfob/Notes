# Best/Worst Case Complexities:

## Tower of Hanoi:

```  
  Best: 2^n
  Worst: 2^n
  Recurrence: 2T(n-1) + 1
```

## Binary Search:

```
  Best: O(1)
  Average: O(logn)
  Worst: O(logn)
  Recurrence Relation: T(n/2) + 1
```

## QuickSort

```
  Best: O(nlogn)
  Average: O(nlogn)
  Worst: O(n^2)
  Recurrence: T(n) = 2T(n/2) + bn
              T(1) = b
```

## MergeSort

```
  Best: O(nlogn)
  Average: O(nlogn)
  Worst: O(nlogn)
  Recurrence: T(n) = 2T(n/2) + bn
              T(1) = b
```

## Classical Matrix Multiplication

```
  Best: O(n^3)
  Worst: O(n^3)
```

## Divide and Conquer Matrix Multiplication

```
  Best: O(n^3)
  Worst: O(n^3)
  Recurrence: T(n) = 8T(n/2) + bn^2
              T(1) = b
```

## Strassens Matrix Multiplication

```
  Best: O(n^2.81)
  Worst: O(n^2.81) or n^log_2(7)
  Recurrence: T(n) = 7T(n/2) + bn^2
              T(1) = b
```

## Integer Multiplication

```
  Best: O(n)
  Worst:  O(n^1.58)
  Ave: O(n^1.58)
  Recurrence: T(n) = 3T(n/2)+bn
              T(n) = b
```


# Minimum Spanning Tree

## Prim

```
  Time: O(n^3)
  Clever Data: O(n^2)
```

## Kruskals

```
  Implementation: O(e log e)
  Dense Graph: O(n^2 log n)
  Sparse Graph: O(n log n) 
```

# Greedy

- Knapsack
- Knapsack 0/1
```
  O(Mn)
```
- Knapsack 0/1/2

## Integer Knapsack

```
(M+1)(n+1) entries and O(M) times
therefore O(M^2 * n)
```



## All combinations
```
n!
```



# Dynamic

## Chained Matrix

```
O(r^3)
```

# NP

1.  If P = NP, then all problems in NP can be solved in polynomial time deterministically: ``true``
2. It is known that Satisfiability is NP-complete. Assume that an O(n^2013) deterministic 
algorithm has been found for the Satisfiability problem, then P = NP: ``true``
3. If a decision problem A is NP-complete, proving that A is reducible to B, in 
polynomial time, is sufficient to show that B is NP-complete. ``false`` show B in NP first
