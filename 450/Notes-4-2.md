#CS 450 Notes 
## 4/2/2013

## Introduction to Computability
- 2 ways to describe a language
    - Recognition
        - FSA
        - PDA
    - Generation
        - Regex
        - CFG

Ordered by superset -> subset:

```
L(Turing Machine) = L(Unrestricted Grammar)
            Recursively Enumerable Langauge

L(CFG) = L(PDA)
      CFL

L(regex) = L(FSA)
       Regular Language
```

## Main Topics

1. FSA w/ different features 
2. Turing Machine
3. Undecideable/Uncomputable problems
4. Tractable/Intractable(NP-Complete) Problems

## DFSA
A determinisitic finite state automata (dfsa) is a 5-tuple
``M = (S,E,D,P0,F)`` where:
    - S is a finite sets of states
    - E is a finite alphabet of input symbols
    - D: ``S x E -> S`` (the transition function)
    - P0 in S, the initial state
    - F subset of S, set of final states

### Example: DFSA
- Design a DFSA to accept all strings over ``{0,1}`` containing ``101``
    - Drawing in notes
- ``L = {x in {0,1}* | x represents binary evenly disible by 3}o        - Drawing in notes
- {0,1} with 0 3rd from end
    - Drawing in notes

## NFSA
A nondeterministic finite state automaton (nfa) is a 5 tuple ``M = (S,E,D,P0,F)`` where everything is defined as before, except ``D: S x E -> 2^s``

### Example: NFSA
- Same 3rd from last problem
    - 4 states, initial with 0/1 loop

### Computation Tree
- Just draw a tree for w/e the input is and look for a successful path

## Subset Construction Algorithm
- Way too lazy to write that...
- ``2^S``, so if S = {0,1,2,3}
    - 2^4 = 16 possible
    - S = {theta, {1},{2}...,{1,2},...{0,1,2,3}}
- Make table, trace path

```
                 0                  1
p0               {p0,p1}           {p0}
p0p1             ... ...
```


## Alternating Finite State Automaton
- Consider parallel machines
