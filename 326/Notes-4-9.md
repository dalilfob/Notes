# STA 326 Notes
# 4/9/2013

## Determining Number of Elements
- Fundamental Principle of Counting
    - Example: How many possible 3-digit alpha passwords are there 
        - Repeated ok:
            - ``(26)(26)(26) = 17,576``
        - Not repeating:
            - ``(26)(25)(24) = 15,600``

- Permutations
    - Choosing r objects from n distinct objects order matters
    - ``nPr = n! / (n - r)!``

- Combinations
    - Choosing r objects from n distinct objects, order DOES NOT matter
    - ``nCr = n! / r!(n - r)!``

## 3.3 Probability
- Classical Probability Concept:
    - If there are m equally likely possibilities, of whic one must occur and s are considered favorable, or as a "success", then the probability of success is ``s / m``
        - ``m`` = sample space

    - The probability of an event (outcome/success) is the proportion of time the event occurs in the long run of repeated experiments

    - **Example**: Among the first 842 convection ovens, 143 require repair during warranty period.
        - What is probability that a new oven would require repairs?
            - ``143/842 = 0.170``

    - **Example**: A committee of 5 is selected from a group of 6 men and 9 women
        - What is the probability that the committee consists of 3 men and 2 women?
            - Want number of possible successes (3 men 2 women) over all possible combinations
            -``(6_C_3)(9_C_2) / (15_C_5)``
            - = ``(20)(36) / 3003 = 0.24``

## 3.4 & 3.5 Axioms and Theorems of Probability

- ``P(A)`` = probability of A occuring

### Axioms

- Event A and B in sample space S
    - ``0 <= P(A) <= 1``
        - **Example**: Deck of Cards
            - P(club) = ``13/52 = 1/4 = 0.25``
    - ``P(S) = 1``
        - **Example**: ``P(card) = 1``

    - If A and B are mutually exclusive (disjoint) events in S, then
        - ``P(A u B) = P(A) + P(B)``
            - ``P(hearts union clubs) = P(hearts) + P(club) = .25 + .25 = .50``

### Theorem 1
- If ``A1,A2,A3,...An`` are mutually exclusive then ``P(A1 u A2 u A3 ... u An) = P(A1) + P(A2) + ... + P(An)``

- When events ``Ai`` are mutually exclusive and cover the entire sample space,
    ``summation(P(Ai) = 1``

    - **Example**: Mineral Samples
        - Is this a valid assignment of probability?
            - P(contains Silver Ag) = 0.38
            - P(doesn't contain silver) = .52
        - NOT VALID, adds up to .9

    - **Example**: Drilling Operation
        - Valid?
            - P(success) = .34
            - P(!success) = -.66
        - NOT VALID, no negatives

### Venn Diagram in Notes

```
P(A) = 15 / 32
P(B) = 13 / 32
P(A u B) = 23 / 32
P(A n B) = 5 / 32
P(A u B)' = 9 / 32
```

### General Addition Rule Theorem
If A and B are events in S, then 

```
P(A u B) = P(A) + P(B) - P(A n B)
P(A u B) = 15/32 + 13/32 - 5/32 = 23/32
```

## 3.6 Conditional Probability
- ``P(A)`` means probability of A given some understood sample space S
    - ``P(even numbered card) = 20 / 52``
    
    -``P(A | S)`` 
        - Restrict sample space
            - B = event of black card
            - A = event numbered card
        - ``P(event numbered card | event black card) = P(A | B) = even numbered black cards / number black cards = 10 / 26``

    - ``P(even | black) = N(even n black) / N(black)``
    
### Probability Formula

```
P(A | B) = N(A n B) / N(S)
          ----------------
           N(B) / N(S)

P(A | B) = P(A n B)
          ----------
             P(B)
```

### Venn Diagram in Notes
    - Figure 2
    - Triple venn diagram



```
a) P(A|B) = P(A n B) / P(B) = (.04 + .06)/(.04 + .06 + .11 + .19) = .25

b) P(B | C') = P(B n C') = (.6 + .19) / (1 - P(C)) 
             = .25 / (1 - .4) = .417
```
