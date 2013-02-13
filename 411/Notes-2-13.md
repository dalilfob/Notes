# Notes CS 411
## 2/13/2013

### LL(K) Grammars and Parsers, k > 1

Example: 

```
S -> aAaa | bAba
A -> b | epsilon
```
> LL(1) ? X
> LL(2) ? 

- Building an LL(K) parser for, ``k>=2``, involves replacing the nonterminals in the parser with "tables" or "items". These tables describe a nonterminal and its *local follow set*

```
T(0) = Ts, {eps}
--------------
First2(aAaa) (+) {eps} = {ab,aa}
First2(bAba) (+) {eps} = {bb}

{ab,aa} intersect {bb} = \theta 
Since there is no conflict, we can continue...
```

```
lookahead production    local follow set
--------- ----------    ----------------
ab }      S -> aAaa     for A: {aa} (+) {e} = {aa}:T1
aa }                    
bb        S -> bAba     for A: {ba} (+) {e} = {ba}:T2
```

> Clearly we need to make table T1 and T2

```
T1 = T_A, {aa}
--------------
First2(b) (+) {aa} = {ba}
First2(eps) (+) {aa} = {aa}

{ba} intersect {aa} = \theta

Since there is no conflict, we can continue...
```


```
lookahead production    local follow set
--------- ----------    ----------------
ba        A -> b        no nonterminals on RHS
aa        A -> eps      no local follow set 
```


- Then for T2


```
T2 = T_A, {ba}
--------------
First2(b) (+) {ba} = {bb}
First2(eps) (+) {ba} = {ba}

{bb} intersect {ba} = \theta

No conflict, continue
```

```
lookahead production    local follow
--------- ----------    ------------
bb        A -> b
ba        A -> eps
```

- Using these Ti's, we build the following L(2) parser:


```
    aa      ab      ba      bb      a       b       eps
T0  aT1aa   aT1aa           bT2ba 
T1  eps(4)          b(3)
T2                  eps(4)  b(3)
a   pop     pop                     pop   
b                   pop     pop             pop 
$                                                  accept
```

LL(2) Parsing for bba
|stack      | input| output|
|-----------|------|-------|
|T0$        | bba  | eps   |
|bT2ba$     | bba  | 2     |
|T2ba$      | ba   | 2     |
|ba$        | ba   | 2,4   |
|2, $       | eps  | 2,4   |



### Another Example of LL(2), k >= 2

```
S -> AB
S -> BC
A -> ab
A -> CBba
A -> baaS
B -> bb
B -> bbAS
B -> baB
C -> aaa
C -> aabS
```

> We can tell this can not be LL(2), try looking a head
> for C ...aa and aa , won't work 

Check if LL(3)

```
First3(S) = {abb, baa, aaa, aab, bab, bba, bbb}
      (A) = {ab, baa, aaa, aab}
      (B) = {bab, bba, bbb, bb}
      (C) = {aaa, aab}

T0 = T_S, {e}
-------------
First3(AB) (+) {eps} = {abb, baa, aaa, aab}
      (BC) (+) {eps} = {bab, bba, bbb} 


First3(AB) intersect First3(BC) = \theta

No conflict, continue...

lookahead production    local follow set
--------- ----------    ----------------
abb }     S -> AB       For A: First3(B) (+) {e}: T1
baa }                   For B: {e} (+) {e} : T2
aaa }
aab } 

bba }     S -> BC       For B: First3(C) (+) {e} : T3
bbb }                   For C: {e} (+) {e} : T4 
bab } 
```

- Then we caculate

```
T1 = T_A, {bb,bba,bbb,bab}
--------------------------
First3(ab) (+) {bb,bba,bbb,bab} = {abb}
First3(CBba) (+) {bb,bba,bbb,bab} = {aaa,aab}
First3(baaS) (+) {bb,bba,bbb,bab} = {baa}

No conflicts 


lookahead production    local follow set
--------- ----------    ----------------
abb }     A -> ab       no follow set

aaa }     A -> CBba     For C: First3(Bba) (+) 
                        {bb,bba,bbb,bab} = 
                        {bbb,bba,bab} : T5

aab }                   For B: First3(ba) (+)
                        {bb,bba,bbb,bab} =
                        {bab} : T6


baa }     A -> baaS     For S: {e} (+) 
                        {bb,bba,bbb,bab} =
                        {bb,bba,bbb,bab} : T7
```

- Then calculate table for B

```
T2 = T_B, {eps}
---------------
First3(bb) (+) {e} = {bb}
First3(bbAS) (+) {e} = {bba,bbb}
First3(baB) (+) {e} = {bab}

No conflicts


lookahead production    local follow set
--------- ----------    ----------------
bb  }     B -> bb       no follow set

bba }     B -> bbAs     for A: First(S) (+) {e} =
                        {abb,baa,aaa,abb,bba,bbb,bab} : T8

                        for S: {e} (+) {e} = {e}: T0
bab }     B -> baB      for B: {e} (+) {e} = {e}: T2


```

Holy ... this is never going to end

- Calculate:

```
T3 = T_B {aaa,aab}
------------------
First3(bb) (+) {aaa,aab} = {bba}
First3(bbaAS) (+) {aaa,aab} = {bba,bbb}
First3(baB) (+) {aaa,aab} = {bab} 
```

### Theorem to determine LL(K)

- Theorem A CFG G is LL(K) iff the follow holds: if ``A->B`` and ``A -> y`` are distinct productions, then the ``First_K(Ba) intersect First_K(ya) = \theta`` for all ``wAa`` such that ``S -> wAa`` 

#### Example 
```
S -> (S)S | [S]S | eps
```

- Is this grammar LL(1)?

- Look at the notes, I'm not writing that ... 

#### Example

```
S -> Aa
A -> bAb | eps
```

- Is this LL(1) ?
- Clearly not because First(A) is b, and Follow(A) is b, and intersect is not \theta 

#### Example

```
S -> aAaa | bAba
A -> b | eps
```

```
Follow(S) = {eps}
Follow(A) = {a,b}



```

- G is LL(2)

> Look at lecture notes, too lazy
