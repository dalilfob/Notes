#Notes CS 411 
## 1/16/2013

### Homework 1 Review

### 1

#### (a) 
`a^n b^n c^n | n >= 0, complement`

```
= {a^i b^j c^k | i != j or j!=k} union {all strings without form a^i b^j c^k}
```
> See drawn DFSA for second half 

```
S -> XC | AY | D
X -> aXb | aA | bB
A -> aA | epsilon
B -> bB | epsilon
C -> cC | epsilon
Y -> bYc | bB | cC
D -> aD | bE | cF
E -> aG | bE | cF
F -> aG | bG | cF
G -> aG | bG | cG | epsilon 
```

#### (b)
```
Doc -> epsilon | E  Doc
E -> Text | <EM> Doc </EM> | <OL> List </OL> |
     <P> Doc 
Text -> epsilon | char Text 
char -> a-zA-Z0-9 | space 
List -> epsilon | ListItem List
ListItem -> <LI> Doc
```

### 2
#### (a) Convert to proper form

```
S -> aBa
B -> Sb | bCC | CC | DaE | epsilon
C -> abb | DD | epsilon
D -> aDB 
E -> aC
```

1. Delete epsilon-production:

```
E = {B,C}

S -> aBa | aa
B -> Sb | bCC | bC | b | CC | C | DaE
C -> abb | DD
D -> aDB | aD
E -> aC | a
```

2. Delete single-productions

```
B -> Sb | bCC | bC | b | CC | DaE | abb | DD
```

3. Delete nonproductive nonterminals

```
P = {S,B,C,E}
Delete D because non-productive

S -> aBa | aa
B -> Sb | bCC | bC | b | CC | C 
C -> abb
E -> aC | a
```

4. Delete inaccessible symbols

```
A = {S,a,B,b,C}
E is inaccessible => remove
```

**Proper Form**:

```
S -> aBa | aa
B -> Sb | bCC | bC | b | CC | C  
C -> abb
```

#### (b) to CNF

```
S -> <a><BA> | <a><a> |
<a> -> a
<Ba> -> B<a>
B -> S<b> | <b><CC> | <b>C | b | CC | <a><bb>
<bb> -> <b><b>
<b> -> b
<CC> -> CC
C -> <a><bb> 
```

### CYK Example

```
S -> AB | CA
A -> a
B -> BC | AB | a
C -> AB | b
```
Matrix table:

```
3 [S,B,C ]
2 [S,B,C ][S,B,C ] 
1 [A,B   ][A,B   ][A,B   ]
    a     a     a

```

> Yes, aaa is in the language because the intial non-term (S) is in the top box 

#### Derivation Tree
- See drawing

### PDA 

```
[a][b][a][b][b][b][a] } one way read only input tape
^
|                |   |           
-------------    |   |
| finite    |    |   |
| control   |--->|Z0 |
|   P_0     |    ----- 
-------------

```
Translates to:

```
D(P,a,Z) = (q,g)
    if g = epsilon // pop
    if g = Z // no change 
    if g = ZZ // push
```

### NPDA
- Machine always makes correct choice

```
D(P,a,Z) = {(q1,r1),(q2,r2)}
```

#### Definition of NPDA
A nondeterministic Pushdown Automaton (NPDA) is a 7-tuple...where:
1) S is a finite set of states
2) \sigma is a finite set of input symbols
3) \gamma """""""""""""""""""" stack
4) \delta is a transition function mapping 
5) P_0 in S, the initial state
6) Z_0 in \gamma the initial stack symbol
7) F (c with underline thingy) S , the set of final states


> We use empty stack model 

#### Example
PDA for `{ww^R | w in {a,b}^+`

```
D(P0,a,Z0) = (P0,AZ0)
D(P0,b,Z0) = (P0,BZ0)
D(P0,a,A)  = {(P0,AA),(P1,e)}
D(P0,b,B)  = {(P0,BB),(P1,e)}
D(P0,a,B)  = (P0,AB)
D(P0,b,A)  = (P0,BA)
D(P1,a,A)  = (P1,e)
D(P1,b,B)  = (P1,e)
D(P1,e,Z0) = (P1,e) // accept 
```

#### Example
PDA for `{a^n+1 b^2n | n >= 0}

```
D(P0,a,Z0) = (P1,AZ0)
D(P1,e,A)  = (P2,e)
D(P2,e,Z0) = (P2,e) // accept
D(P1,a,A)  = (P1,AA) // push a's
D(P1,b,A)  = (P3,e) // pop last a (n-1) to get n
D(P3,b,A)  = (P4,A) // do nothing
D(P4,b,A)  = (P3,e) // pop 1 a for every 2 b
D(P3,e,Z0) = (P3,e) // accept
```    

#### Example
PDA for:
```
E -> (L) | a
L -> L , E | E
```

```
D(P0,a,Z) = (P0,e) // accept a
D(P0,(,Z) = (P1,LZ0)
D(p1,L,L) = (P1,LL)
D(P1,a,L) = (P2,L)
D(P2,(,),L) = (P1,L)
D(P2,),L) = (P2,e)
D(P2,e,Z0) = (P2,e)
```
- Every left paren, push it (balanced parens) 
- every a or comma, skip it 
- Use 2 states to guage:
    - after left paren you can take left paren, or a 
    - after a only change state to p2 to check for comma or right paren 
