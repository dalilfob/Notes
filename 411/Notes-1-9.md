#CS 411 Notes
## 1/9/2013

###A Gramar G = (N,E,P,S) is 
1. **Right Linear** if every production has the form 
- RLG is a RLL language

    A -> xB
    A -> x
    where (A,B \element N), x \element E*
    P => (N U E)* N (N U E)* x (N U E)*

2. ** Context-Free ** if every rule has a single nonterminal on it's left side.
- CFG is a CFL language 

3.** Context-Sensitive** if every rule has the form ''a -> B'' such that |a| <= |B|
- CSG is a CSL language

    CSL (w/o e):
      CFL (all computer languages are CFLs):
        RLL
     
####Example
RLG to generate all strings containing 101


    S-> 0S | 1S | 101T
    T-> 0T | 1T | e


 Without RLG restriction:

    S-> A101A
    A-> 0A | 1A | e

####Example
RLG for all signed/unsigned integers w/o leading 0s
  
    S-> +T | -T | T   
    T-> 1..9X | 0
    X-> 0..9X | e

####Example
RLG all strings over {a,b} whose lengths is a multiple of 3

    S-> aT | bT | e
    T-> aX | bX
    X-> aS | bS

####Example CFG
CFG all balanced parentheses

    S-> (S) | SS | e
    or
    S-> (S)S | e

####Example CFG
CFG for {ww^R | w \element {a,b}*}

    S-> aSa | bSb | e

####Example CFG
CFG for {ww^R | w \element {a,b}*}^C <-- complement of above
- We want to generate all odd length strings, all even length strings NOT palindromes

    S  -> S1 | S2
    S1 -> aS1a | aS1b | bS1b | bS1a | b | a
    or
    S1 -> S1S1S1 | a | b
    S2 -> aS2a |bS2b | aXb | bXa
    X  -> aXa | aXb | bXa | bXb | e

####Example CFG
{a^i b^j c^k | i != j or j != k, i,j,k > 0}

    S -> XC | AY
    C -> cC | c
    X -> aXb | aAb | aBb
    A -> aA | a
    B -> bB | b
    Y -> bYc | bBc | bCc

### Context Sensitive Grammars
#### Example
CSG for {x # x | x \element {a,b}* } E = {a,b,#}
ab#ab

Because there is no limit on size, we have to use a stack, but then again it is impossibly to use a single stack...therefore it is not a context free grammar

We must use a context sensitive grammar 

    S-> aAs | bBS | T
    Aa -> aA  %
    Ab -> bA  %  permutation
    Ba -> aB  %     rules
    Bb -> bB  %
    AT -> Ta  <
    BT -> Tb  < Termination Rules
    T  -> #   <

**Note**: See drawn derivation tree to visualize how the production rules are
dependant on where the symbol appears

    By definition: CSG (context sensitive languages) are more powerful than CFGs

###Ambiguity
A CFG G is **ambiguous** if for any sentence x \element L(G) there are 2 distinct derivation trees 

####Example
    
    G:
      S -> aSaS | a | e

    S=>aSaS=>aaaS=>aaa
    S=>aSaS=>aaS=>aaa

**Note**: If a grammar is ambiguous, theoretically it is not-computable

####Example

    S-> if E then S else S | 
        if E then S | s
    E-> e or E | e  

    Given:  "If e then if e then s else s" 
    
    S => if E then S else S => if e then S else S => if e then (if E then) else S
    => if e then (if e then) else s

    or

    S => if E then S => if e then S => if E then S else S => ...clearly ambiguous

###CFG to Proper Form Review
####Example e-Free

    S -> AB | bAC
    A -> e | aB
    B -> e | cSa
    C -> aS | bBS

    Step 1 (gather all nonterminals that produce e):
      E_1 = {A, B,} // generate e in 1 steps
      E_2 = {A, B, S} // generate e in 2 steps 

    Step 2 (replace productions by muting symbols that go to e)
      S -> AB | A | B | bAC | bC
      A -> aB | a
      B -> cSa | ca
      C -> aS | a | bBS | bS | bB | b

    Step 3 (if initial generates e , then add S' -> S | e)
      S' -> S | e
      ...same as above...

###Example e-Free

    S -> ABC
    A -> Cb | e
    B -> dA | e | A
    C -> q | f

    Step 1:
      E_1 = {A,B}

    Step 2:
      S-> ABC | BC | AC | C
      A -> Cb 
      B -> dA | d | A
      C -> q | f

##Homework 1 Posted on Blackboard

