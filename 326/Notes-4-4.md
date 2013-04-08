# STA 326 Notes
## April 4, 2013

## Quiz 1
1. Stem and leaf plots
    - give data from the plot

2. Describe meaning of standard deviation
    - Average distance between observations and the sample mean
    - Measure of how spread out the data is

3. Find the quartiles for the following sample:
    

```
4 8 9 1 4 12 11 10
```

    - Sort the data
    - Q1 = (8)(.25) = 2 = (4+4/2) = 4
    - Q2 = (8)(.5) = 4 = (8+9/2) = 8.5
    - Q3 = (8)(.75) = 6 = (10+11/2) = 10.5


## Chapter 3: Probability
- Probability: the measure of a likelihood of an outcome, when the outcome cannot be predicted with certainty 

### 3.1: Sample Space / Events 
- **Sample space**: ``S`` : set of all possible outcomes
    - Example: Deck of Cards
        - Sample Space: {A hearts, K hearts, ...2 Clubs}
        - SIze of Sample Space: 52
    - **Finite Sample Space**: Countable number of elements
    - **Continous Sample Space**: Elements constitute a continuum
        - Example: all points between (0,1)

- **Event**: Any subset of the sample space
    - **Mututally Exclusive Events** (disjoint): No elements in common
        - Example: Let A be subset of red cards and B black cards
            - A = {hearts, diamonds}
            - B = {spades, clubs}
        - Let C be the set of face cards
            - C = {jacks, queens, kings}

        - A and B are mutually exclusive
        - (A and C) and (B and C) are NOT mututally exclusive 

#### Set Theory Notation and Venn Diagrams

- Union: ``A U C``
    - (Union Venn Diagram here)

    - ``A U C`` = {hearts, diamonds, JQK spades, JQK clubs}
    
- Intersection: ``A n C``
    - (Intersection Venn Diagram here)

    - ``A n C`` = {JQK hearts, JQK diamonds}

- Complement: ``A'`` (should actually have bar over it)
    - Everything in the sample space that's not in ``A``
    - A complement = {spades, clubs} = B
    
    - Example:  ``(A U C)'`` 
        - ``A U C`` = {hearts, diamonds, JQK spades, JQK clubs}
        - Complement of that is: {A ...10 of spades and clubs} 
        - Venn Diagram is same as union, except shading outside of circles

### 3.2 Counting 

- Example: Consumer report rating lawn mowers
    - Ease of Operation:
        - easy (E1)
        - average (E2)
        - difficult (E3)
    - Price:
        - inexpensive (P1)
        - expensive (P2)
    - Cost of Repairs:
        - low (C1)
        - average (C2)
        - high (C3)

> How many ways can a lawn mower be rated?

```

                mower
                / | \
              E1  E2 E3
             / \  .   .
            P1  P2
           /|\
         c1 c2 c3
``` 

- 18 possibilities

#### Fundamental Principle of Counting

If sets ``A1,A2, ...Ak`` contain respecively ``n1,n2, ...nk`` elements, then there are ``(n1)(n2)...(nk)`` ways of firt choosing from A1, then choosing from A2...finally choosing an element from Ak.

- Example: 
    - A1 : Easy of operation , n1 = 3
    - A2 = price , n2 = 2
    - A3 = cost of repairs, n3 = 3
    - Number of possibilities: (3)(2)(3) = 18

- Example:
    - In a class of 35, choose representatives to negotiate homework
        - 1st Chair
        - 2nd Chair
    - How many different ways can one chose these 2 representatives from a pool of 35 students
        - 35 choices for 1st chair
        - 34 choices for 2nd chair
            - ``35 * 34 = 1190``
            - This is known as a permutation, because order matters


- **Factorial Notation**
    - 0! = 1
    - 3! = (1 x 2 x 3)

- **Permutation** ordered arrangement of r objects chosen from n distinct objects
    - Classroom Representatives: If picked 1st chair Erik, and 2nd chair Aileen
    - Different from 1st chair Aileen, 2nd chair Erik
    - ``nPr = n! / (n-r)!``

- ``35 P 2 = 35! / (35 - 2)! = 35! / 34! = (35)(34)= 1190``
    - Size of sample space: 35
    - Size of sample: 2

- **Combinations**: An arrangement of r objects chosen from n distinct objects, where one combination differs from another only if the content of the arrangement differs
    - Example: Erik Aileen == Aileen Erik
    - ``nCr = (35)_P_(2) / 2 = 595 combinations``
    - If we select 3 objects: A, B, C
        - 1st chair: (3)(2)(1) = 6
        - 2nd chair: (2)(1)
        - 3rd chair: (1)


```
(n)    nPr
( ) = -----
(r)     r!

    =   n!
      -----
      r!(n-r)!

```


- Example: TV producer has 6 commercials ready to run.  
    - How many ways can he order these commercials?
        - 6! = 720
    - How many ways can he choose 4 of the commercials to 4 commercials to fill slots 1,2,3,4
        - Permutationa: ``(6)_P_(4) = 6! / 2! = 360``

    - How many ways can he choose to send 3 of the 6 commercials to an affiliate station?
        - Combination: ``(6)_C_(3) = 6! / 3!(6-3)! = 20``


- Example: Select a committee of 5 from a group of 6 men and 9 women
    - How many ways can 2 men and 3  women be selected
        - Combinations: number of ways men x  number of ways women
            - Men: 6 choose 2: 15
            - Women: 9 choose 3: 84
            - (15)(84) = 1260 combinations


- Exammple: Stats clas sof 35, 32 CS majors, and 3 theatre majors. How many ways can the Dean of Science select two students to interview 
    - And get no theatre students?
        - 32 choose 2 , and 3 choose 0 
        - ``(32! / 2!*30!) * (3! / 0!*3!) = 496 combos
    - How many ways to get 1 theatre major?
        - 32 choose 1, and 3 choose 1 = 96 combinations
    - How many possibilities to get 2 theatre majors?
        - 32 choose 0 (goes to 1), 3 choose 2 = 3 combos

## Problem Set 2

3.9 , 3.10 , 3.14, 3.20, 3.23 - 3.27
