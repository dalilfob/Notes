# CS 411 Notes
## 3/4/2013

### Techniques for LR Parsing Tables

- SLR - Simple LR (carries no follow set)

- LALR - Look Ahead LR (carries follow set, but merge tables with common cores)
    - CUP & YACC implement these 

- Canonical LR

#### Example

```
(1) S -> aXc
(2) X -> bX
(3) X -> b
(4) X -> Yd
(5) Y -> Yd
(6) Y -> d

- No augument (S never on right hand side)

A0 = V1(eps)
------------
I: [S-> .aXc, eps] 

1 item, consistent

A1 = V1(a),goto(A0,a)
----------
I:[S -> a.Xc, eps]
  [X -> .bX, c]
  [X -> .b, c]
  [X -> .Yd, c]
  [Y -> .Yd, d]
  [Y -> .d, d]

- All shifts, consistent

A2 = V1(aX), goto(A1,X)
-----------
I: [S -> aX.c, eps]

- 1 item, consistent

A3 = V1(ab), goto(A1,b)
-----------
I: [X -> b.X, c]
I: [X -> b. , c]
   [X -> .bX, c]
   [X -> .b, c]
   [X -> .Yd, c]
   [Y -> .Yd, d]
   [Y -> .d, d]

c in EFF1(Xc) = No
         (bXc) = No
         (bc) = No
         (Ydc) = No
         (Ydd) = No
         (dd) = No
- Consistent, continue

A4 = V1(aY), goto(A1,Y)
-----------
I: [X -> Y.d, c]
I: [Y -> Y.d, c]

- All shift, consistent

A5 = V1(ad), goto(A1,d)
-----------
I: [Y -> d. , d]

- 1 item, consistent

A6 = V1(aXc), goto(A2,X)
------------
I: [S -> aXc. , eps]

- 1 item, consistent

A7 = V1(abX), goto(A3,X)
------------
I: [X -> bX. , c]

- 1 item, consistent


A8 = V1(aYd), goto(A4,d)
------------
I: [X -> Yd. , c]
I: [Y -> Yd. , d]

c in EFF1(d) = no
d in EFF1(c) = no
```

> G is LR(1) 

- Create Parser

```
    a   b   c   d   (e) | S  X  Y  a  b  c  d  
A0  S                              A1
A1      S       S            A2 A4    A3    A5
A2          S                            A6
A3      S r,3   S            A7 A4    A3    A5
A4              S                           A8
A5             r,6
A6                 r,1*
A7        r,2
A8        r,4  r,5
```
- ``*`` indicates acceptance
- Combine GOTO actions with Parsing Action Section

 ```
    a   b   c   d   (e) | S  X  Y  a  b  c  d  
A0  S1                             A1
A1      S3      S5           A2 A4    A3    A5
A2          S6                           A6
A3      S3 r,3  S5           A7 A4    A3    A5
A4              S8                          A8
A5             r,6
A6                 r,1*
A7        r,2
A8        r,4  r,5
```

### SHIFT TABLE, looks insane
- Look at notes online 


