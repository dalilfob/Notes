# Notes CS 411
## 1/13/2013

### Equivalence of CFG and PDA
- For any G there must exist a PDA that can recognize a set of all strings that G can generate
- Same for the other way


#### \forall CFG, PDA exists 
- **Algorithm** : G = (N,E,P,S) be a CFG
    - Construct M = {{q},E, N(union)E,D,q,S,theta} where
        1. (q,a) in D(q,e,A) for all A -> a in P
        2. D(q,a,a) = D(q,e) for all terminals 

#### Example

```
E -> E + T | T
T -> T * F | F
F -> (E)   | a
```

Construct m = ({q},{+,*,(,),a},{E,T,F,*,+,(,),a},D,q,E,theta) where D:

```
    D(q,e,E) = {(q,E+T), (q,T)}
    D(q,e,T) = {(q,T*F),(q,F)}
    D(q,e,F) = {(q,(E)), (q,a)}
    D(q,+,+) = (q,e)
    D(q,*,*) = (q,e)
    D(q,(,() = (q,e)
    D(q,),)) = (q,e)
    D(q,a,a) = (q,e) 
```

#### Example
- Given ``w = a * a + a`` where ``w in L(G)``
    - Draw a derivation tree to show that it's in L(G)
    - Initial stack symbol will be E (NOT Z0) 


### Membership Problem
- Given a CFG (G) , and a string (x), is x in G ? 
    1. CYK Algorithm
        - Unfortunately this is O(n^3) complex
    2. PDA 
        - Unfortunately CFG -> PDA produces a NONDETERMINISTIC PDA
    3. llk and lrk algorithms 

### Deterministic PDA
- Something something, what's going on here
- No more than 1 place to go (1 transition on right side)
- No e-move AND input-move for same state->stack symbol 

CAN NOT HAVE:

    ```
        D(P,e,Z)
        D(P,a,Z) 
    ```

- DCFL is subset of CFL 
    - ``ww^R`` requires nondeterminism 

### Lexical Analyzer
Role of lexical analyzer (aka Scanner):
    1. Chop the stream of input chars into tokens
    2. Store identifiers into symbol table 

## Homework 2 Due Monday, Project #1 Due Wed 
