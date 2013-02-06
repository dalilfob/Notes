# CS 411 Notes
## 2/6/2013

### Eliminate Left Immediate Recursion

```
A -> Aa | bA | Ac | d

rewrite to:

A -> bAQ | dQ
Q -> aQ | cQ | epsilon 
```

The parse table will look like:

Follows:

```
Follow(Q) = Follow(A) = {eps}
and First(Q) + Follow(A) = {eps} + {eps,a,c} + Follow(A)

```


```
    a   b   c   d   epsilon
A       1       2
Q  4,3     5,3        3
```

> This grammar is no LL(1) because there's a conflict 

Can convert to ``LL(1)`` by: 


```
A -> bA | dQ
Q -> eps | aQ | cQ
```

Then:

```
Follow(A) = {e}
Follow(Q) = {e} 
```

### Left Factoring Example 

```
A -> aB1 |
     aB2 | 
      .
      .
      .
     aBn

Can't be LL(1), but we can

A -> aB
B -> B1 | B2 | ... Bn 
```

#### Example

```
S -> id( ) | id (L)
L -> L,id | id
```

- Left factoring the S

```
S -> id(S' 
S'-> ) | L)
```

- Remove left recursion of L

```
S  -> id(S'
S' -> ) | L)
L  -> idL'
L' -> epsilon | ,idL'
```

- Now check, is this grammar LL(1) ? 


```
    id  (   )   ,   epsilon
S   1   
S'  3       2
L   4
L'          5   6
id  p
(       p   
)           p
,               p
$                   accept
```
> No conflict, therefore ``LL(1)`` 
> p means pop 


#### Example

```
S -> epsilon | abA
A -> Saa | b


First(S) = {a,epsilon}
First(A) = {a,b}
Follow(S) = {epsilon,a}

Because empty string is in the language, and it's a lookahead,
then use empty string in the table 

    a   b   epsilon
S  2,1          1
A   3   4
```

> Not ``LL(1)`` because 1 symbol look a head isn't enough 


### Homework 3 Review

1. Given the grammar

```
S -> aAbc | BCf
A -> c | eps
B -> Cd | c
C -> df | eps

First(S) = {a,c,d}
First(A) = {c,eps}
First(B) = {c,d}
First(C) = {d,eps} 

Follow(S) = {eps}
Follow(A) = {b}
Follow(B) = {d,f}
Follow(C) = {d,f} 

    a   b   c   d   f   epsilon
S   1       2   2
A       4   3
B           6   5
C              7,8
```

> The grammar is not ``LL(1)`` because there's a conflict 

    - Show a top down parsing for input string "df"
    
        
        ```
            Stack   Input   Output
            S$      df      epsilon
            BCf$    df      2
            CdCf$   df      2,5
            conflict 
        ```

    - Caculate ``First3(ABC)``


        ```
            First3(ABC) = First3(A) + First3(B) + First3(C)
            = {c,eps} + {c,dfd,d} + {df, eps}
            = {cdf, cdd, cd, ccd, cc, dfd, ddf, d, c}
        ```

2.


```
A -> BCc | eDB
B -> eps | bCDE
C -> DaB | ca
D -> eps | dD
E -> eAf | c

First(B) = {b,eps}
First2(BD) = First2(B) + First2(D)
           = {eps,bc,bd,ba} + {eps,d,dd}
           = {eps,bc,bd,ba,d,dd}

Follow(B) = {a,d,c,eps,f,e}  
Follow(D) = {a,e,c,eps,f,b}


Parser:

    c   e   b   a   d   f   eps
A   1   2   1   1   1
B   3   3   4   3   3   3    3
C   6           5   5
D   7   7   7   8       7    7
E  10   9
```
> No conflict, so the grammar is ``LL(1)`` 

    - Perfrom parsing for "ac"

    
    ```
    Stack   Input   Output
    A$      ac      epsilon
    BCc$    ac      1
    Cc$     ac      1,3
    DaBc    ac      1,3,5
    aBc$    ac      1,3,5,7
    Bc$     c       1,3,5,7 (pop)
    c$      c       1,3,5,7,3 
    $       eps     1,3,5,7,3 (pop)
    $       eps     accept and output 1,3,5,7,3 
    ```

3. Removing left recursion

Equivalent without 
```
R  -> (R)R' | aR'
R' -> eps | +RR' | dotRR' | *R'
```

### Midterm on Monday
- Everything up to today
    - CFG, PDA, Chompsky, CYK, LL(k), Membership problems (equivalent pda), etc
    
