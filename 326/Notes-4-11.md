# STA 326 Notes
# 4/11/2013

## Tree Diagram Monte Hall
![Monty Hall Tree](http://illuminations.nctm.org/lessons/9-12/monty/Tree4.png)

## CH.4 Probability Distribution
    
### 4.1 Random Variables
- **Random Variable** (``X``)
    - Is a quantitative variable, that has values that vary according to the rules of probability
    - Invovles outcomes of numerical values

#### Example

Roll of 2 dice 

```
# Spots on top of 2 dice
S = {2,3,4...,12}

Possible Outcomes
-----------------
11 21 3  4  5  6
12 22 .  .  .  .
13 23 .  .  .  .
14 24 .  .  .  .
15 25
16 26
```

> 36 possiblities

```
Look at the diagonals in the previous table:

P(X=2) = 1/36 = P(X=12)
P(X=3) = 2/36 = P(X=11)
P(X=4) = 3/36 = P(X=10)
P(X=5) = 4/36 = P(X=9)
P(X=6) = 5/36 = P(X=8)
P(X=7) = 6/36
```


- **Random Variable**:
    - Is any function that assigns a numercal value to each possible outcome

#### Example

An experiment invovles tossing 2 coins

```
Sample Space S = {HH, HT, TH, TT}
```

Establish a variable to describe the possible outcomes

```
Let X = # of heads that appear on the two coins
   
Probabilities of Random Var:
    X = 0 -> 1/4
    X = 1 -> 1/2
    X = 2 -> 1/4
```

#### Examples With Outcomes

Situation where numbers are associated with outcomes of a random experiment

```
a) X = # children in a family

b) X = # of dentists in finite sample who were nitrous oxide

c) X = # of errors on a test

d) X = # of broken eggs in a dozen
```

#### Outcome whose numbers can be assigned

**Whether it rains or not on a particular day**

```
S = {rain, no rain}

if rain:
    x = 1
if !rain:
    x = 0
```

**Childrens Blood Type**

```
Blood Types & Allels
--------------------
Type O = OO
Type A = AA or OA
Type B = BB or OB
Type AB = AB

Scenario:
    
    Mom = Type A (OA)
    Dad = Type O (OO)
    
Probabilities
    
    Mom     Dad     Type
    ---     ---     ----
     O       O      OO -> O
     A       O      AO -> A

    P(O) = 1/2      P(A) = 1/2
    
Have 3 Kids
-----------

Sample Space = {AAA, AAO, AOA, OAA, AOO, OAO, OOA, OOO}

Random Variable
---------------

X = # of Children w/ Type A blood

P(X = 3) = P(AAA) = P(A)*P(A)*P(A) = 1/8
P(X = 2) = 3/8
P(X = 1) = 3/8
P(X = 0) = 1/8    
```

> Just look at the sample space

### Examples with Finite # of Possibilities

- Discrete Random Variables
- Infinite number of possiblities
    - Continuous ranodm variables

#### Example

a) light bulb burns until it burns out

```
X = lifetime of a bulb in hours
X = 120 hours
X = 131.6 hours
X = 102.94 hours
```

b) X = Random consuption for a type of car (Sedan) driving 100 miles

```
X = 3.5 gal
X = 2.2 gal
X = 2.1562 gal
.
.
.
```

> Continuous random variable

#### Situation That Doesn't Work as Random Var

Colors of style of shirt from Urban Outfitters. Find the number of each color sold:

```
S = {teal, gray, black, canary, brick}
X = ?????? ... how to quantify
```

### Probability Distribution 

 ``f(x)`` of a random variable is a function which assigns probability to each possible outcome ``x``:

```
f(x) = P(X = x)
```

The probability distribution of a discrete random variable ``X`` is a list of possible values of ``X`` and their probabilities

Probability Distribuutions Satisfy

```
0 <= f(x) <= 1
 
     and

sum(f(x)) = 1
```

#### Example
Two Dice

```
S = {2,3,4,...12}

sum(f(x)) = sum(P(X=x))

where X = rand number, and x = one from S 

sum(f(x)) = P(X=2) + P(x=3) + ... + P(X=12) 
          = 1/36 + 2/36 + ... 1/36 = 1
```

### The Cumulative Distribution

``F(x)`` is the probability that the value of the random number variable is less then or equal to x.


```
F(x) = P(X <= x)
```

#### Example
Probability of getting at most one head on a throw ofa pair of coins:


```
X = # of heads in 2 coin tosses
S = {HH, HT, TH, TT}

F(1) = P(X <= 1) = 1/2 + 1/4 = 3/4
```

### Histogram vs Bar Graph
- Too lazy

```
X | P(X = x)
------------
0 | .25
1 | .5
2 | .25


|   -----
|   |   |
|   |   |
|---|   |---
|   |   |   | 
|   |   |   |
|   |   |   |
------------------
```

> widths are significant or histograms
> widths are not significant for bar graphs

### 4.2 Binomial Distribution

Collect data to find the number of "successes" x in ``n`` trials

#### Example
Suppose you are inspecting a case of iPADS before shipment for obvious craks in the screen. The case from which you are sampling has 24 iPADS, of which 3 have cracked screens. 


This falls under the bionomial model for it satifies the 4 criteria:

1. There are two possible outcomes for each trial 
    - (Broken Screen vs Not Broken)

2. Probabilitiy of succes ``p_s`` is constant from trial to trial

3. Outcomes of trials are independent from different trials are independent

4. There are a fixed number of trials conducted
    - ``# of trials n = 24``
    - ``successes x = 3``



**Binomial Distribution**

```
b(x,n,p) = (n choose x)P^(x) * (1-p)^(n-x)
```


#### Example

Roll one die 4 times.

Probability of rolling a 6 exactly one time out of 4 Binomail experiment?

```
(1) Only 2 possible outcomes? 
    success - rolled 6
    failure - don't roll 6

(2) Probability constant?
    p = 1/6  

(3) outcomes independent
    yes    

(4) Fixed # of trials
    4 trials


Possibilities
-------------
R = Roll

R1  R2  R3  R4
--  --  --  --
S   F   F   F
F   S   F   F
F   F   S   F
F   F   F   S

Probability
-----------
(1/6)(5/6)(5/6)(5/6) = 125/1296
(5/6)(1/6)(5/6)(5/6) = same
same for rest

Probability of Exactly one 6 in 4 rolls
----------------------------------------
(125/1296) + (125/1296) + (125/1296) + (125/1296) 

= 125 / 324

Probability of some specific order of one succes / 3 failures
-------------------------------------------------------------

(1/6)^1 * (5/6)^(4-1) = p^(x) * (1-P)^(n-x)

4 choose 1

    (4 c 1) = 4

Binomial
    Probability of Exactly x successes in n trials given the probability of success in 1 trial is p

    b(x,n,p) = (n c x)p^(x) = (1-p)^(n-x)

```

#### Example

Fine the probability of getting exactly 4 successes in 10 trials when the probability of success is 0.4.
Satisfies the binomial critera:

``
(10_C_4)(.4)^4 * (1-.4)^(10-4) = .2508
``


## Problem Set 4
4.2 - 4.5
4.9 - 4.11
4.15 - 4.16

