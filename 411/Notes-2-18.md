# Notes CS 411
## 2/18/2013

### LR(k) Gramars
- Read input LEFT to RIGHT 
- Right most derivation (bottom up) 
    - Backwards right most derivation

- Given ``G = {N,E,P,S} be a CFG``

- Suppose  `` S -> aAw -> x `` is a right most derivation. We say that the sentential form ``aBw`` can be reduced under the production ``A -> B`` to the sentential form ``aAw``. We call the substring ``B`` a handle of ``aBw`` 

#### Example

Given the following CFG and a rightmost derivation

```
(1) S -> SaSb
(2) S -> eps

Rightmost Derivation:

S -> SaSb -> SaSaSbb -> SaSabb -> Saabb -> aabb 
```

- Go backwards, which handles did we use

```
aabb (2) -> Saabb (2)-> SaSabb (2)-> SaSaSbb (1) -> SaSb (1) -> S
```

- We say that aabb can be reduced under S –> ε to Saabb, 

   Saabb can be reduced under S –> ε to SaSabb, SaSabb can be 

   reduced under S –> ε to SaSaSbb, SaSaSbb can be reduced 

   under S –> SaSb to SaSb, which can then be reduced under S 

   –> SaSb to the root S.

- Stack and input

```
stack input
----- -----
eps   aabb
S     aabb
Sa_e  abb
SaS   abb
SaSa  bb
SaSaS bb
SaS   b
SaSb  eps 
S     eps
```

- Accepted because root of derivation tree at end 

> Bottom-up or Shift-reduce parsing

### LR(K) 

- Intuitively, a gramm is ``LR(k)`` if, given a rightmost derivation, we can isolate the handle of each sentential form and determine which nonterminal is to replace the handle by scanning ``a_i`` from left to right, but only going at most ``k`` symbols past the right end of the handle ``a_i``. 


### Definition LR(k)

- Let ``G = (N,E,P,S) be a CFG and let G' be its  augmented grammar. G' = {N,U,(S'),E,P (union) (S'-S),S').``

- We say that ``G`` is ``LR(k)`` if:
    1. ``S -> aAw -> aBw``
    2. ``S' -> yBx -> aBy, and
    3. FIRSTk(w) = FIRSTk(y)

- Imply that ``aAy = yBx`` i.e that ``a = y, A = B, and y = x) 

