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
