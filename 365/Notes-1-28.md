# CS Notes 365
## 1/28/2013

### Agenda
- EX #3 Due 
- Lect 3b
    - Floating Point Representation
    - Floating Point addition
- Project #1 Assigned
- HW #3 Due on Wednesday 


```

1 01001111 11010

Sign Bit: 1 (negative)
Exponent: 01001111 = 79.
79 - 127 = -48

= -1.11010 x 2^-48

```

### F.P. Addition
- Shift the smaller one, because the worst case is it shifts to 0

- Align them (same exponent) 

- 0.0 is all 0's by convention 


```
Alignment:

if e1 > e2:
    shift f2 by e1 - e2
else:
    shift f1 by e2 - e1 
```

#### Example 

```
    9.9721 x 10^2
  + 3.9667 x 10^-1
  
  shift:
    
    9.982100 x 10^2
    0.003966 x 10^2
  ------------------
    9.986066 x 10^2
```

#### Example

```
    9.9821 x 10^1
  + 3.9667 x 10^1
  ---------------
  13.9488  x 10^1

  Normalize: 1.39488 x 10^2
  Rounding: 1.3949 x 10^2 
```

- In this class, assume truncation instead of rounding so we don't have to normalize after rounding

- Multiplexer to make choices 
- e1,e2 into an ALU, subtract, send that result to control...see diagram 
