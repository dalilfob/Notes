# CS 411 Notes 
## 2/4/2013

### Agenda / Changes
- Homework 3 wed 2/6
- Project 1 wed 2/13 
- Midterm Monday 2/11 


### Exercise Review

```
S -> Aa
A -> bAb | e

First(S) = {a,b}
First(A) = {b,e}

Follow(S) = {e} <-- because it's the initial,and root of tree,  nothing can follow 
Follow(A) = {a,b} 
```

> Note: we only do follow for those with epislon in first 


- ``LL(1)`` Parser

> See notes for drawn table 


### Exercise 2

```
S -> ABc
A -> aA | e
B -> bB | e

First(S) = {a,b,c}
First(A) = {a,e}
First(B) = {b,e}

Follow(S) = {e}
Follow(A) = {b,c}
Follow(B) = {c}
```

> Lookahead = First + Follow 
> Every regular langauge has an ``LL(1)`` grammar 
> Every reg.lang has a DFSA -> right linear grammar , then every
> production rule begins with distinct terminal 
> => simple ``LL(1)``


### Example: LL(1)?

```
E -> E + T | T
T -> T * F | F 
F -> (E) | a

E -> E+T -> a*a*a...*a + a
E -> T -> a*a*a8*a...*a

Therefore not LL(1) 
```

So in general

```
A (+)-> Aa  left recursion 
         cannot be LL(k) 

Immediate left recursion: A -> Aa
Indirect left recursion : A -> Ba ; B-> Ab
```

### Remove Immediate Left Recursion

- Left ``A`` be any nonterminal and all ``A``-productions be of the form:

```
    A -> Aa1 | Aa2 | ...Aan| B1 | ...Bm
```

- Where none of the ``Bi's`` begin with the nonterminal ``A``. Then we can replace the set of ``A``-productions by:

```
A generates (B1 + B2 +...+Bm)(a1+a2+...an)*
```

```
    A -> B1 | B2 | ...Bm | B1A' | B2A' | ...Bm'
    A' -> a1 | a2 | ...an | a1A' | a2A' | ...anA'
```

> ``A'`` generates kleene closure in above regex 

#### Example

```
E -> E + T | T
T -> T * F | F
F -> (E) | a
```

To non-left recursive version:

```
E  -> TE'
E' -> e | +TE' 
T  -> FT'
T' -> e | *FT'
F  -> (E) | a 
```

Determine if above is ``LL(1)``


```
First(E) = {(,a}
First(E') = {+,e}
First(T) = {(,a}
First(T') = {*,e}
First(F) = {(,a} 

Follow(E) = {),e}
Follow(E') = {e, )}
Follow(T) = {e,),+)
Follow(T') = {e,),+)
Follow(F) = {e,),+,*} 
```

> Try to trace this with ``(a+a)*a`` 


### Example Problem

```
A -> Aa | bA | Ac | d 
    
1. Remove immediate left recursion 
2. Check if LL(1) 
```
