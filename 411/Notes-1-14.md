#Notes CS 411
## 1/14/2013

### Proper Form Conversion (cont.)
- \epsilon-free
- No unit productions (single productions)
```
  E -> E+T | T
  T -> T*F | F
  F -> (E) | a
```
Deleting Single productions via replacement:
```
  E -> E+T | T*F | (E) | a
  T -> T*F | (E) | a
  F -> (E) | a
```

#### Useless Symbols
- A symbol is useless if it is nonproductive or inaccessible

#### Example
```
  S -> ABC | BaB
  A -> aA | BaC | aaa
  B -> bBb | a
  C -> CA | AC 
```
- Calculate all productive nonterminals:
```
  {} // generate \sigma^{*} in 0 step
  {A,B} // . . . 1
  {A,B,S} // ... 2 steps
  {A,B,S} // ... 3 steps
```
- When current set = previous set, then stop

> Clearly C is nonproductive, delete C

```
  S -> BaB
  A -> aA | aaa
  B -> bBb | a
```

- Calculate all accessible symbols
```
  {S} // in 0 step
  {S,B,a} // in 1 step
  {S,B,a,b} // in 2 steps
  {S,B,a,b} 
```

> A is inaccessible 

```
  S -> BaB
  B -> bBb | a
```

###Proper form Summary
- Delete e-production
- Delete single (unit) production
- Delete non-productive
- Delete inaccessible 

#### Example

```
S -> A | B
A -> C | D
B -> D | E
C -> S | a | epsilon
D -> S | b
E -> S | c | epsilon 
```
- Delete e production

```
  Set of epislon generating NTs = {S,A,B,C,D,E}
  
  S'-> eps | S
  S -> A | B 
  A -> C | D
  B -> D | E
  C -> S | a 
  D -> S | b
  E -> S | c
 
```
- Remove unit productions

```
  S'-> eps | a | b | c
```
- Inaccessible / Nonproductive (none in above)
  - Done ;D

### Chompsky Normal Form
A CFG is in *Chompsky Normal Form* **(CNF)** if G is \epsilon-free and every non-e-production is of the form: `` A->BC or A->a, where A,B,C \element N and a \element (\Sigma)``

### CNF Conversion Algorithm
- **Input**:` A proper form CFG G = (N,E,P,S)` 
- **Output**:` A CFG in CNF G' s.t. L(G) = L(G')`
  - Consider only A-> X1X2X3...Xk , where k > 2, assuming xi \element N (a nonterminal) 
    - Convert:
      ```
        A-> X1X2X3
        to
        A -> X1<X2X3>
        <X2X3> -> X2X3
      ```
- If Xi \element (\SIGMA)
  - Replace by <Xi> first, then add `<Xi> -> xi` 

#### Example
```
  S -> aAbb | BA
  A -> BBB | a
  B -> AaS | b
```

**Convert to Chompsky Normal Form**

```
  S     -> <a><Abb> | BA
  <a>   -> a 
  <Abb> -> A<bb>
  <bb>  -> <b><b>
  <b>   -> b
  A     -> B<BB> | a
  <BB>  -> BB
  B     -> A<aS> | b
  <aS>  -> <a>S
```

### Membership Problem
- Compiler: a membership problem 
- Decision Problem:
  - Given a CFG G and string X: `is x \element L(G)` ?
- CYK Algorithm (Cocke-Younger-Kasami) 
  - Uses dynamic programming approach 
  - **Input**: CNF CFG (G)  and a String (x)
  - **Output**: Yes if x in L(G), No otherwise 
  - Complexity: O(|x|^3) where |x| is the length of input 

#### Example
```
S -> AS | BC | SS | a
A -> BB | AS | CA | a
B -> CB | AA | BC | b
C -> SC | AS | CC | b
```
Given String x = ababbaba 

- Property of CNF:
  - |x| = 1 (simple / trivial)
  - |x| = 2 
    - If we go backwards to generate a,b we require {S,A} for **a** and {B,C} for **b**. So we look for: SB, SC, AB, or AC  
  - |x| = 3 
    ```
      []
      /\
    []  []
    /\   |
   [][]  a
   |  | 
   a  b
   ```
    - We require CS or CA from this tree, generated from A
    - The mirror tree would require SA or AA, generated fromB
      - Requires {A} union {B} = {A,B} 
      - Not in language (no generation of AB)  

  - |x| = 4, would require 5 derivation trees 

#### See written notes for lower-matrix drawing

### CYK Algorithm Definition
Let S1 and S2 be set of nonterminals
Define.
```
  S (product) S2 = { A | A->BC in P and B in S1, C in S2}
  {S,A} (product) {B,C} = {C}
```
Define.
```
  S_i,j = S_i-1,j (product) S_1,j+(i-1) (union)
     S_i-2,j (product) S_2,j+(i-2)      (union)
        S_i-3,j (product) S_2,j+(i-3)   (union)
                  .
                  .
                  .
            S_i,j (product) S_(i-1),(j+1) 

```
