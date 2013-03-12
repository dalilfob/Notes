# Notes CS 411
## 3/11/2013

## Homework 5 Review

### Question 1

```
S -> XYXY
X -> 0X | eps
Y -> 1Y | eps

LR(0)
LR(1)
LR(k)? 

- Not LR(k) for any k
```


> Deterministic CFL is a language that may be recognized by a deterministic PDA

## Question 2

```
C -> begin L end
L -> L ; S | S
S -> C | a | eps

LR(1)?

Augment Grammar because C is on right hand side

(0) C' -> C


A0 = V1(eps)
------------
I: [C' -> .C, eps]
   [C -> .begin L end, eps]

- All shift, consistent

A1 = V1(C),goto(A0,C)
----------
I: [C` -> C., eps]

1 reduce, consistent

A2 = V1(begin),goto(A0,begin)
--------------
I: [C -> begin . L end, eps]
   [L -> .L ; S , ;|end]
   [L -> .S, ;|end]
   [S -> .C, ;|end]
   [S -> .a, ;|end]
   [S -> . , ;|end]
   [C -> .begin L end, ;|end]

   ; | end eff1(all other shift items) = nope
   consistent 

A3 = V1(beginL),goto(A2,L)
---------------
I: [C -> begin L. end, eps]
   [L -> L.;S, ;|end]
   
- All shift, no conflict

A4 = V1(beginS),goto(A2,S)
---------------
I: [L -> S. , ;|end]

- 1 item, consistent

A5 = V1(beginC),goto(A2,C)
---------------
I: [S -> C. , ;|end]

- 1 item, consistent

A6 = V1(begin a),goto(A2,a)
----------------
I: [S -> a. , end|;]

- 1 item, consistent

A7 = V1(beginbegin),goto(A2,begin)
-------------------
I: [C -> begin. L end, end|;]
   [L -> .L ; S , ;|end]
   [L -> .S, ;|end] goto A4
   [S -> .C, ;|end] goto A5
   [S -> .a, ;|end] goto A6
   [S -> . , ;|end]
   [C -> .begin L end, ;|end] goto A7

- Same reasoning as A2, consistent

A8 = V1(beginLend),goto(A3,end)
------------------
I: [C -> begin L end.,eps]

- 1 item, consistent

A9 = V1(beginL;),goto(A3,;)
----------------
I: [L -> L;.S, ;|end]
   [S -> .C, ;|end] goto A5
   [S -> .a, ;|end] goto A6
   [S -> . , ;|end]
   [C -> .begin L end, end|;] goto A7

- Same reasoning as A3 & A2, consistent

A10 = V1(begin begin L), goto(A7,L)
-----------------------
I: [C -> begin L. end, end|;]
I: [L -> L.;S, end|;]

- All shift items, consistent

A11 = V1(begin begin L end), goto(A10,end)
---------------------------
I: [C -> begin L end., end | ;]

- 1 item, consistent

```

> Test: MAY ask for LALR implementation, or Canonical 


Build LR(1) Parser:

```
   begin  end  ;  a  eps |  C  L  S
A0 s,2                      A1  
A1                   r0*    A5 A3 A4
A2 s,7    r6   r6 s,6        
A3        s,8   s,9
A4        r3   r3
A5        r4   r4
A6        r5   r5
A7 s,7    r6   r6 s,6        A5 A10 A4
A8                   r1
A9 s,7    r6   r6 s,6        A5    A11
A10       s,12  s,9
A11       r2   r2
A12       r1   r1
```

## Semantic Analyzer
- Define Semantic Actions & Perform Type Checking

- Example:
    - Identifiers are not multiply declared
    - Reference IDs have been previously declared 
    - Operand types are compatible with operator types
    - Actual and formal parameters agree in numbers and types

## SDD (Syntax Directed Definition)

> Essentially an annotated CFG 

A CFG G = (N,E,P,S) in which:

1. Each grammar symbol ``x in N union E`` is associated with a set of attributes (synthesized or inherited)

2. Each production rule ``A -> x1 x2 . . . xn`` is associated with a set of semantic rules of the form `` b = f(a1 a2...ak) where:

    - b is a synthesized attribute of A if ``a1 a2...ak`` are attributes of ``x1 x2...xn`` or inherited attributes of A

    - b is an inherited attribute of ``Xj`` if ``a1 a2...ak`` are attributes of A, ``x1,x2...xn``


### Example: SDD For a Calculator

```
Production              Semantic Actions
----------              ----------------
L -> E eoln             L.dummy = print(E.val)
E -> E + T              E.val = E1.val + T.val
E -> T                  E.val = T.val
T -> T * F              T.val = T1.val * F.val
T -> F                  T.val = F.val
F -> (E)                F.val = E.val
F -> num                F.val = num.lexval
```

```
            L
           / \
          E  eoln
         /|\
        E + T
        |   |
        T   F
       /|\   \
      T * F   num(4)
      |   |
      F  num(5)
      |
     num(3)
```

> How do we know it's 3? : lexical analyzer

- Attributes:

```
L.dummy    (synthesized)
E.val      (synthesized)
T.val      (synthesized)
F.val      (synthesized)
num.lexval (synthesized)
```

### SSD: Declaration Statement

```
Production          Semantic Action
----------          ---------------
D -> T L ;          L.in = T.type
T -> int            T.type = integer  
T -> double         T.type = integer
L -> L , id         L.in = L.in; addtype(L.in, id.entry)
L -> id             addtype(L.in, id.entry)
```
