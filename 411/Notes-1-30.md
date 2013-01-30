# Notes CS 411
## 1/30/2013

### LL(K) Grammars
- CFGs that we can build a top-down parser for
- L: left to right
- L: left most derivation
- K: Amount of look-a-head allowed 

#### Example


```
S -> aAs | b
A -> a | bSA
```

- Above denoted as "simple" LL(1) grammar 
- Given ``w = abbab`` 
- Look a head with ``a`` and choose ``aAs``
- look a head for ``b`` choose ``bSA`` from ``A``
- look a head for ``b`` choose ``b`` from ``S``

#### Example

```
S -> e | abA
A -> Saa | b 
```

> where ``e`` is epsilon 

- The above is ``LL(2)`` not ``LL(1)`` 
- Given ``aba ...`` 

#### Example

```
S -> A | B
A -> aAb | a a | 0
B -> aAbb | 1
```

> Above is not ``LL(k)`` for any value of k 

```
        S
        |
        A
       /|\
     a  A  b
       /|\
     a  A  b
        .
        .
    
```

May also be:


```
        S
        |
        B
       /|\ \
      a B b b
        .
        .

```

- Requires arbitrarily large values of ``k`` , therefore intuitively not ``LL(k)`` grammar 

### Definition

- Let ``G = {N,E,P,S}`` be a CFG
    - G is ``LL(k)`` if whenever there are 2 leftmost derivations
    - ``S => wAa => wBa => wx``
    - ``S => wAa => wGa => wy``
    - such that ``FIRST_k(x) = FIRST_k(y)``, then ``B = G`` 

- Ambiguous grammars are clearly not ``LL(k)`` 

- Divide CFG:
    - Ambiguous
    - Unambiguous
        - ``LL(k)``
        

### Definition
- ``FIRST_k(a) = { w in E* | a -> w and |w| < k``
    - or ``a -> wx and |w| = k, x in E*``

> E is sigma in this case


```
S -> aAS | b
A -> b | bSA
```


- To determine ``FIRST_1(S)``:
- Mark terminals: ``= {a,b}``

```
        S
      /   \
    aAS    b
    
```

- ``FIRST_2(S)``:
- ``={aa,ab,b}`` 

```
        S
      /   \ 
    aAS    b
    / \
   aaS abSAS
```

- ``FIRST_1(A) = {a,b}``
- ``FIRST_2(A) = {bb,ba,a}`` 


> See blackboard lecture notes 

- ``FIRST_3(aAb)``
    - Apply ``FIRST`` on ``a`` , ``A``, and ``b``
    - `` = {a} (concat) {a,bba,baa,bab,bbb} (concat) {b} ``
    - `` = {aab, abb (truncate), aba (truncate)} 


### Parse Table

#### Example

> See notes for table 

- Convert to PDA
- the same symbols are either pop or error depending on pda 
- empty stack and extra symbol = error 


### LL(1) Parsing for "abbab"

| stack | input | output|
|------:|------:|------:|
|S$     |abbab  |   e   |
|aAS$   |abbab  |   1   |
|AS$    | bbab  |   1   |
|bSAS$  | bbab  |  1,4  |
|SAS$   | bab   |  1,4  |
|bAS$   | bab   | 1,4,2 |
|AS$    | ab    | 1,4,2 |
|aS$    | ab    | 1,4,2 |
|S$     | b     |1,4,2,3|
|b$     | b     | same  |
|$      | e     | same  |

- From ``{1,4,2,3}`` we can determine the left-most derivation (by numbering the grammar from left to right) 
