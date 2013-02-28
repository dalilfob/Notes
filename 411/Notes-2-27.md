# CS 411 Notes
## 2/26/2013

### LR(2) Example

```
(1) S -> bAbb
(2) S -> aAab
(3) A -> a
(4) A -> eps

A0 = V2(eps)
------------
I: [S -> .bAbb, eps]
I: [S -> .aAab, eps]

Consistent, only shift items

A1 = V2(b)
----------
I: [S -> b.Abb, eps]
   [A -> .a, bb]
   [A -> .  , bb]

Check Consistency
    
    bb ? EFF2(Abb) = {ab} x
         EFF2(abb) = {ab} x

consistent

A2 = V2(a)
----------
I: [S -> a.Aab, eps]
   [A -> .a, ab]
   [A -> . , ab]

Check consistency:

    ab ? EFF2(Aab) = {aa} x
         EFF2(aab) = {aa} x

consistent

A3 = V2(bA) = goto(A1,A)
-----------
I: [S -> bA.bb, eps]

Only one item, consistent

A4 = V2(ba) = goto(A1,a)
-----------
I: [S -> a. , bb]

Only one item, consistent

A5 = V2(aA) = goto(A2,A)
----------
I: [S -> aA.ab, eps]

Only one item, consistent 

V6 = V2(aa) = goto(A2,a)
-----------
I: [A -> a. , ab] 

Only one item, consistent

V7 = V2(bAb) = goto(A3,b)
------------
I: [S -> bAb.b, eps]

Only one item, consistent

V8 = V2(aAa) = goto(A5,a)
------------
I: [S-> aAa.b , eps]

Only one item, consistent

V9 = V2(bAbb) = goto(A7,b)
-------------
I: [S -> bAbb. , eps]

Only one item, consistent

V10 = V2(aAab) = goto(A8,b)
--------------
I: [S -> aAab. , eps]

Only one item, consitent

No conflicts anywhere => Grammar is LR(2) 

```

#### Corresponding  LR(2) Parser

```
    aa      ab      ba      bb      a       b       eps  |   S   A   a   b
--------------------------------------------------------------------------
A0                  s       s                                        A2 A1
A1          s               r,4                                  A3  A4
A2  s       r,4                                                  A5  A6
A3                          s                                           A7
A4                          r,3                                      
A5          s                                                        A8
A6          r,3                                                   
A7                                         s                            A9
A8                                         s                            A10
A9                                                 r,1(a)                
A10                                                r,2(a) 
```

#### Parsing on babb with above parser

```
stack           input           output
-----           -----           ------
A0              babb            eps
A0bA1           abb             eps
A0bA1aA4        bb              eps
A0bA1AA3        bb              3
A0bA1AA3bA7     b               3
A0bA1AA3bA7bA9  eps             3
A0S             eps             3,1

Output: 1,3 (input is eps, so accepted) 
```

### LR(0) Exercises/Examples

#### Example 1
```
S -> Sa | a 
```

Augment:

```
S' -> S
S  -> Sa
S  -> a

A0 = V0(eps)
------------
I: [S' -> .S]
   [S  -> .Sa]
   [S  -> .a]

Check consistency: all shift, so consistent

A1 = V0(S)
----------
I: [S` -> S.]
I: [S  -> S.a]

Check consistency:

because we have 0 looka head, we see eps

eps ? EFF0(a) = {eps}

Conflict 
```




#### Example 2

```
S -> aC
C -> Ab
A -> eps

A0 = V0(eps)
------------
I: [S -> .aC]

One item, consistent

A1 = V0(a), goto(A0,a)
----------
I: [S -> a.C]
   [C -> .Ab]
   [A -> .  ]

eps ? EFF0(C)  = \theta 
    ? EFF0(Ab) = \theta

consistent

A2 = V0(aC), goto(A1,C)
-----------
I: [S -> aC.]

Only one item, consistent

A3 = V0(aA) = goto(A1,A)
-----------
I: [C -> A.b]

Only one item, consistent

A4 = V0(aAb) = goto(A3,b)
------------
I: [C -> Ab.]

Only one item, consistent

=> Grammar is LR(0)

```

> NOTE , EFF0 ( ) may produce 2 results
> eps or theta, theta happens if a terminal can not produce
> anything without the use of an e production 


** Parser for Above ** :

```
   eps      S   C   A   a   b    
A0 s                A1
A1 r,3          A2  A3
A2 r,1(a) 
A3 s                        A4
A4 r,2
```


### LL(K) Theorems
- Every LL(K) grammar is also an LR(K) grammar
- Every DCFL has a LR(1) grammar 

### Project 2  & Homework 5 Assigned
- Part 1:
    - Create SLR parsing table
    - Create a CFG for toy, put it into the SLR table thingy
    - Output: parsing table

- Part 2: 
    - Input: parsing table, and tokens (project 1 lexical analyzer) 
    - Perform parsing 
    - One symbol lookahead LR Parsing 


- Overview:

```
Source Program -> Project 1 -> Tokens -> Part 2 
CFG -> Part 1 -> Parsing Table -> Part 2

Part 2 -> sequence of parsing actions 
```



