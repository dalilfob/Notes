# Notes CS 4111
## 2/25/2013

### Homework 4 Review

#### Question 1
##### (A)
```
S -> eps | abA
A -> Saa | b

First(SAS) = {e, aba, abb} (+) {b, aa,abb,aba} (+) {e, aba, abb}
= {aa, aaa, aba, abb, b, bab}
```

##### (B)
```
To = Ts, {e}
------------
First2(E) + {e} = {e}
First2(abA) + {e} = {ab}

{e} n {ab} = \theta 
No conflict

lookahead production follow
--------- ---------- ------
eps       S -> eps   none
ab        S -> abA   For A: {e} + {e} : T1

T1 = TA, {e}
------------
First2(Saa) + {e} = {aa,ab}
First2(b) + {e} = {b} 

No conflict

lookahead production follow
--------- ---------- ------
aa }      A -> Saa   For S: {aa} + {e} = {aa} : T2
ab }

b         A -> b     None


T2 = TS, {aa}
-------------
First2(e) + {aa} = {aa}
First2(abA) + {aa} = {ab}

No conflict

lookahead production follow
--------- ---------- ------
aa        S -> e     none 
ab        S -> abA   For A: {e} + {aa} : T3

T3 = TA, {aa}
-------------
First2(Saa) (+) {aa} = {aa,ab}
First2(b) (+) {aa} = {ba}

No conflict

lookahead production follow
--------- ---------- ------
aa }      A -> Saa   For S: {aa} : T2
ab } 
ba        A -> b     none

-> G is LL2
```

```
    aa     ab       ba   bb   a   b    eps
T0         abT1(2)                     e(1)
T1 T2aa(3) T2aa(3)                b(4)
T2 e(1)    abT3(2)
T3 T1aa(3) T2aa(3)  b(4)
a  p       p                  p
b                   p    p        p 
$                                      accept
```

##### (C) Top-Down Parsing

```
Stack           Input           Output
-----         ---------       ---------
T0$           ababbaa          e
abT1$         ababbaa          2
bT1$           babbaa          2
T1$             abbaa          2
T2aa$           abbaa          2,3
abT3aa$         abbaa          2,3,2
bT3aa$           bbaa          2,3,2
T3aa$             baa          2,3,2
baa$              baa          2,3,2,4
aa$                aa          2,3,2,4
a$                  a          2,3,2,4
$                 eps          2,3,2,4 (accept) 
```

#### Question 2

```
S -> ABCabcd
A -> a | eps
B -> b | eps
C -> c | eps

LL(2) ?

T0 = TS, {e}
------------
First2(ABCabcd) (+) {e}
= {ab, ac, aa, bc, ba, ca} 

lookahead production    follow
--------- ----------    ------
ab }      S -> ABCabcd  For A: {bc,ba,ca, ab} + {e} : T1
ac }                    For B: {ca,ab} + {e}: T2
aa ]                    For c: {ab} + {e}: T3
bc } 
ba }
ca } 

T1 = TA, {bc,ba,ca,ab}
----------------------
First2(a) + {bc,ba,ca,ab} = {ab,ac,aa}
First2(e} + {bc,ba,ca,ab} = {bc,ba,ca,ab}

CONFLICT, stop
```

#### Qusetion 3, Use Theorem & Prove LL(K)-ness

```
S -> AB
A -> 0A1 | eps
B -> 1B | 1

LL(2) ? 

For S: ok 
For A: 

    First2(0A1) + {1,11} intersect First2(eps} + {1,11} = {00,01} n {1,11} = theta
    First2(0A1) + {11} intersect First2(eps) + {11} = same as above

For B:
    
    First2((1B) + {eps} intersect First2(1) + {eps} = {11} n {1} = theta, no conflict

```

#### Question 4, Prove not LL(2)

```
S -> AB | BC
A -> a | CBS | bSS
B -> b | bAS | bB
C -> a | aSBC


First2(S) = {aa,ab,ba,bb}
      (A) = {a,aa,ab,ba,bb} 
      (B) = {b,ba,bb}
      (C) = {a,aa,ab}


For S:

    First(AB) + {e} intersect First2(BC) + {e} = {ab,,aa,ba,bb} insct {ba,bb} 
            => CONFLICT ALREADY 
```

### Bottom Up Parsing continued...

Prove that the following grammar is LR(0). S never appears on the right side of the production, so we do not need to augument it.

```
S -> C
S -> D
C -> aC
C -> b
D -> aD
D -> c

A0 = V0(eps)
------------
I: [S -> .C]
I: [S -> .D]

   (for each nonterminal after dot, add to table)

   [C -> .aC]
   [C -> .b]
   [D -> .aD]
   [D -> .c]

   All are shift items


A1 = V0(C) = goto (A0,C)
------------------------
I: [S -> C.] // only 1 item, no conflict

A2 = V0(D) = goto (A0,D)
-----------------------
I: [S -> D.] //only 1 item, no conflict

A3 = V0(a) = goto (A0,a)
------------------------
I: [C -> a.C]
I: [C -> a.D]
   
   (non terminal after dot, so add items)

   [C -> .ac] // goto A3
   [C -> .b]  // goto A4
   [D -> .aD] // goto A3
   [D -> .c]  // goto A5 

   // all shift items, no conflict 


A4 = V0(b) = goto(A0,b)
-----------------------
I: [C -> b.] // only item

A5 = V0(c) = goto(A0,c):
-----------------------
I: [D -> c.] // only item

A6 = VO(aC) = goto(A3,C)
------------------------
I: [C -> aC.] // only one item

A7 = V0(aD) = goto(A3,D)
------------------------
I: [D -> aD.] // only one item 

```

No inconsistencies, so the grammar is LR(0).

The LR(0) parser:

> ``s`` is shift
> ``r`` is reduce 
```
    eps       S   C   D   a   b   c
A0  s             A1  A2  A3  A4  A5
A1  r,1      
A2  r,2
A3  s             A6  A7  A3  A4  A5
A4  r,4
A5  r,6
A6  r,3
A7  r,5
```

Then LR(0) parsing based off this table:

```
stack         input       output
-----         -----       ------
A0            aab         eps
A0aA3         ab          eps
A0aA3aA3      b           eps
A0aA3aA3bA4   eps         eps
A0aA3aA3CA6   eps         4
A0aA3aA3CA6 (note, popout 2 times the production length)
A0aA3CA6      eps         4,3
A0CA1         eps         4,3,3
A0S           eps         4,3,3,1
```

> Because we reached root, and input is empty string, we accept
> Output is 1,3,3,4 (reversed because bottom up) 
> Also, grammar is Right Recursive, doesn't affect LR(k) 

#### Another Example

```
S -> Ab | Bc
A -> Aa | eps
B -> Ba | eps
```

> Language cannot be LR(k) for any k
> Because of left recursion 
> It's an identical grammar to the above example 
