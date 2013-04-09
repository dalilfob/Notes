# CS 450 Notes
# 4/9/2013

## Sequential Machines
- DFSA
- NFSA

## Parallel Machines
- AFSA (alternating finite state automata)
    - Existential State
        - Chooses mathematically one of the states given by the transition function to be its next state
    - Universal State
        - Goes to all of the states specified by the transitions
        - ``D(p,a) = {q1,q2}``

### Definition
- An Alternating Finite State Autamaton with e-moves is a 6-tuple ``M =(S(\exists), S(\forall), E, D, Po, F)`` where:
    - ``S(\exists) or S(v)`` is a finite set of existential states
    - ``S(\forall or S(^)`` is a finite state of universal states
    - E: finite set of input symbols
    - D: ``S(\exists) u S(\forall) x (E u {\epsilon}) -> 2^(S(\exists) u S(\forall)``
    - P0 in (S(\exists) u S(\forall)): initial state
    - F subset of (S(\exists) u S(\forall): set of final states


### How to Construct an FSA
- Union of 2 regular languages
    - create new intial, use e-move to connect to initials of both
- Intersection of 2 regular languages
    - cross product algorithm
        - trace consumption of input of both machines
        - works only for DFSA
        - example in class, you know how
            - M1: Even 0
            - M2: Even 1
- Complement of a regular languages
    - Complete machine including transitions to trap states
    - DFSA only
    - Swap non-final with final

### Example, AFSA
- Design an AFSA for ``{x in {0,1}* | x represents binary integer evenly divislbe by 3} \intersect {x in {0,1}* | x has 0 4th from end}``

    - See notes for drawing
    - **Figure 2**

- All universal state's branches must reach final state

- Computation tree for M on ``10101``:
    - **Figure 3**
    - Because every leaf reaches final state, it's accepted

- Change slightly to NOT evenly disible, and NOT 4th from end
    - ``a' and b' = (a or b)'``

    - For the or, make the universal an existential, no longer need dummy
        - **Figure 4**
        - Swap final and non-final
        - If non-deterministic, make universal
        - Computation Tree
            - Not accepting computation: REJECTED
            - **Figure 5**
            - Not all universal splits/branches reach a final

### In-class Exercise
    - Design an AFSA for L = {x in {0,1}* x represents in binary evenly disislbe by 15}
        - Can do DFSA with 15 states
        - Can split AFSA
            - Divide by 3
            - Divide by 5
        - **Figure 6**

    - Same thing, except NOT evenly disible by 15
        - **Figure 7**
        - (by 15)' = (by 3)' or (by 5)'
        - Again: only swap universal/existental when the state is non-deterministic


