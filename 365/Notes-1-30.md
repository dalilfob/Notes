# Notes CS 365
## 1/30/2013

### Floating Point Arithmetic
1. Start
2. Compare exponents, shift smaller number rightward
3. Add significands
4. Overflow -> Exception, Otherwise
5. Round significand
6. Still normalized -> normalize 

### Floating Point Multiplication
Proposed algorithm:

1. Determine sign
2. Add exponents
3. Multiply fractions
4. Normalize
5. Truncation/Rounding 

> See hardware diagram for multiplication 

- Exclusive or the signs to determine sign 
- do ``e1 + e2 + 127`` to get``e`` 
- Then mult ``1.f1 * 1.f2``
- That's ``1 + 23 + 1 + 23 = 48`` bits
- Normalize
- Truncate/Round 
- Overlfow can only occur if exponent out of bounds (``-126 and +127``) 
- Overflow detection unit 1 = overflow, 0 not
    - Input is new ``e`` value (which is ``e1 + e2``  

### Project 1 Assigned
- Design and simulate a floating-point multiplication unit for multiplying two non-zero single precision floating point numbers with truncation as normalization method and an overflow detection...etc

- Cover page, compile instructions, block diagrams, etc 

- Due soon (next week?)

### EXAM 1 , FRIDAY 
- Concepts
    - ISA
    - Load Store Architecture
    - Name 2 features of RISC architecture
    - Addressing modes
        - Immediate, relative, all of them
    - Memory Alignment (byte addressed) 
        - word end 00 (multiple of 4)
        - double word 000 (multiple of 8)
    - Big endian vs Little endian 
- Performance
    - CPI, MIPS, Execution Time/Performance
- Instructions  
    - I-type, J-Type, R-Type instructions 
    - Calculator and green sheet allowed 
- Integer
    - 2's complement representation addition/substraction
    - Integer multiplication VERSION 2  
- Floating Point
    - Addition algorithm 
    - Representation (32 and  64) 
    - No hardware diagram required  
