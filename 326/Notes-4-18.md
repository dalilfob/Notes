# Stats 326 Notes
# 4/18/2013

## Exam 1
- Thurs 4/25
- Chapter 1 & 2
- Sections 4.1 - 4.4 and 4.6 - 4.8


## 4.6/4.7 Poisson Distribution
1. Poisson approximation to Binomial Distribution
    - Binomial Random Variable (X)
        - Number of successes ``X`` in a finite number of trials ``n``
    - When n is very large and the probability p is small, Poisson is applicable

### Poisson Distribution Algo

```
y = lambda
f(x;y) = (y^x)(e^-y) / (x!) } P(X=x)

x = 1,2,3,...

Where y (lambda) = the mean of expected value
                 = np

Show how b(x;n,p) -> f(x,y) as n -> inf & p -> 0
-----------------

Recall:
    lim(x->inf) c/x = 0, where c in R

    lim(n->inf) (1 + 1/n)^n = e

    lim(n->inf) (1 - 1/n)^n = e^-1

    y = np => p = y / n

------------------

b(x;n,p) = (n x)p^x (1-p)^(n-x)
        
         = (n!)/(x!(n-x)!) (y/n)^x (1 - y/n)^(n-x)

         = n(n-1)(n-2)...((n-x)+1) y^x
          ---------------------------- (1-y/n)^(n-x)
            x! n^x

```

> This is where I got bored and stopped trying

- Rule of thumb (WHEN TO POISSON)
    - When ``n >= 20`` and ``p <= 0.05``
    - When ``n >= 100`` and ``np <= 10``

### Poisson Experiments

1. Number of hotel reservations made through expedia in an hour. Contact is random and independent.
    - ``X = number of reservations in 1 hour``
    - ``X = {0,1,2....inf}``

2. Number of pinholes in a square yard of plastic

### Poisson Examples

#### Example 1

Compare the Poisson approximation with the correct binomial probability for P(X = 2) when n = 35 and p = 0.05

```
Binomial 
--------

b(2;35,0.05) = (35_C_2)(0.05)^2 (1-0.05)^(35-2)
             = 0.2737

Poisson
-------
f(x;y) where y = np = (35)(0.05) = 1.75

f(2;1.75) = (1.75)^2 * e^(-1.75) / 2! = 0.2661

```

#### Example 2

Counting number of alpha particles given off in a 1 second interval from 1 gram of radioactive material.From experience an average of 3.2 alpha particles are given off in 1 second. 

Use Poisson to find the probability that no more than 2 particles are given off in a 1 second interval. 

```
y = np = "expected value/aveage" = 3.2


P(X <= 2) = f(0;3.2) + f(1;3.2) + f(2,3.2)

f(x;y) = y^x e^-y / x!

f(x;y) = 0.380
```

### Mean and Variance of Poisson

```
Mean u = y = np

Variance o^2

    From Binomial:
    ---------
    o^2 = np(1-p)
        = y(1-p)
    
    when p->0 (Poisson)
    o^2 = y

```


### Queing Theory

Traffic Flow
Shcedueling
Facility Design

For poisson random processes, we assume

```
1) The mean of the Poisson distribution
    y = aT
    a = # of successes per unit
    T = number of times unit considered

2) The probability during time is not dependent on what happened prior
```

#### Example

If a bus picks up an average of 15 passengers per hour, what is the probability 
    
```
a) 13 passengers are picked up in an hour?
        
    x = 13, a = 15 pass/hour , T = 1 hour
    
    y = 15

    P(X = 13) = f(13,15) = 0.096

b) 30 in 2 hours

    x = 30, y = (15)(2) = 30

    P(X = 30) = f(30,30) = 0.073


```

## 4.8 Geometric Probability Distribution

What is the probability that it will take ``x`` trials to get the first success?

To use this:

```
1) Outcomes: success or failure
2) Trials independent
3) Probability of success is constant

g(x;p)
    x = x trial for first success
    p = probability of success for each trial

g(x;p) = (1-P)^(x-1) P
```

### Example

What's the probability that the first winning spin on the Price is Right occurs on the 5th spin, given that the probability of winning ``p = 0.1``

```
g(5;0.1) = (1-0.1)^(5-1) (.1) = 0.0656
```

Probability of winning on first spin is:

```
0.1
```

## Homework

Due on test date:


