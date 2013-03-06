# Notes CS 411
## 3/6/2013

### SLR Implementation

- S/R Conflict: Usually change the parsing table based on the semantics of the languages 

#### Example

```
S -> if e then S else S
  -> if e then S
```

Given the string "if e then S else S"

```
S
|
if e then S else S
          |
          if e then S
```

Or

```
S
|
if e then S
          |
          if e then S else S
```

> Choose this second derivation

```
Ai:

S -> if e then S else S
S -> if e then S

Always perform shift 
```

In our SLR table, we always check SHIFT Table first before REDUCE, then this case is resolved.

#### Example 

```
E -> not E
E -> E and E
E -> E or E
...
```

Given "not E and E"


```
    E
   / \
  not E
     /   \
    E and E
```

or

```
        E
      / | \
     E  and E
    / \
   not E
```

> 2nd table, and want to always reduce in this case

```
E -> not E.
E -> E.and E
E -> E. or E
```

### R/R Conflict
- Change the grammar 
    - This may introduce more conflicts however

- Change parsing algorithm by extra comparisons 

```
S -> aXc
X -> bX
X -> b
X -> Yd
Y -> Yd
Y -> d
```

> This table has a Reduce Reduce conflict 

```
        S
      / | \
     a  X  c
       / \
      Y   d
     / \
    Y   d
    |
    d
```

- Bottom up, the first Yd reduces to Y, the second reduces to X 
    - CONFLICT

- Change the parsing table
    - In the ``Reduce_Handler`` method, we add

    ```
    if (S == 8):
        if (look_a_head == d):
            p = 5
        if (look_a_head == c):
            p = 4
    ```

    - Clearly if there are many Reduce/Reduce conflicts this adds a riddiculous overhead 

### LALR  
- Look Ahead L R
- Carry follow set, but merge tables with common cores

#### Example

```
(1) S -> CC
(2) C -> cC
(3) C -> d
```

- This generates ``c*dc*d`` and is LR(1) 

```
A0 = V1(eps)
------------
I: [S-> .CC, eps]
   [C-> .cC, c|d]
   [C -> .d, c|d]

All shift, consistent


A1 = V1(C), goto(A0,C)
----------
I: [S -> C.C, eps]
   [C -> cC, eps]
   [C -> .d, eps]

All shift, consistent

A2 = V1(c), goto(A0,c)
----------
I: [C-> c.C, c|d]
   [C -> .cC, c|d] // goto A2
   [C -> .d, c|d] // goto A3

All shift, consistent

A3 = V1(d), goto(A0,d)
----------
I: [C -> d., c|d]

One item, consistent 

A4 = V1(CC), goto(A1,C)
-----------
I: [C -> CC. , eps]

One item, consistent

A5 = V1(Cc), goto(A1,c)
-----------
I: [C -> c.C, eps]
   [C -> .cC, eps] // goto A5
   [C -> .d, eps] // goto A6

All shift, consistent

A6 = V1(Cd), goto(A1,d)
----------
I: [C -> d. , eps]

One item, consistent

A7 = V1(cC), goto(A2,C)
-----------
I: [C -> cC. , c|d]

One item, consistent

A8 = V1(CcC), goto(A5,C)
------------
I: [C -> cC. , eps]

One item, consistent 

```

> G is LR(1) , as proved via canonical approach

**Parsing Table**

```
    c   d   eps     S   C   c   d
A0  s   s               A1  A2  A3
A1  s   s               A4  A5  A6
A2  s   s               A7  A2  A3  
A3  r3  r3
A4          r1*
A5  s   s               A2  A5  A6
A6          r3
A7  r2  r2
A8          r2
```

> Using LALR parser, we merge tables 2/5, 3/6 and 7/8 because they have the same cores 

**LALR Parsing Table**:

```
        c   d   eps     S   C   c   d
A0      s   s               A1  A25 A36
A1      s   s               A4  A25 A36
A25     s   s               A78 A25 A36
A36     r3  r3  r3
A4              r1*
A78     r2  r2  r2
```

- **Parse**: "ccd" using CANONICAL LR(1) 

```
A0              ccd     eps
A0cA2            cd     eps
A0cA2CA2          d     eps
A0cA2CA2dA3     eps     eps
reject
```

- *Parse* "ccd" using LALR

```
A0             ccd      eps
A0cA25          cd      eps
A0cA25cA25       d      eps
A0cA25cA25dA36 eps      eps
A0cA25cA25CA78 eps      3
A0cA25CA78     eps      3,2
A0CA1          eps      3,2,2 
reject
```

### YACC

Yacc Specifications:

```
Declarations 
    (define tokens, associated rules, precedence levels of those tokens)
%%
Rules: 
    CFG and Semantic Actions
%%
Subroutines:
    Call YYParse()
```

The rules may be defined as:

```
A : body;

A -> BCD | EF | G

A : BCD;
A : EF;
A : G;

A : BCD
  | EF
  | G
  ;
```

Pseudo Variables (For easy communication between actions and the parser):

```
$$ 
```

- Which is similar to javas 'this' keyword, referring to itself

```
A : BCD {$$ = 1;}

```

```
$1  }
$2  } Refers to value returned by previous production
$2  }
```

Yacc Generates LALR parser when S/R and R/R conflicts occur: 

1. S/R : perform shift 
2. R/R : perform reduce by the earlier production


Define Tokens:

```
%token name1 name2
%start symbol
%left
%right
%nonassoc
```

- Requires the ``%token`` 

- Left means left associative (like in arithmetic: '+',"-")

- Right means right associative (assignment operator)

- Nonassoc = non associative (not sure...a < b < c shouldn't be allowed) 
