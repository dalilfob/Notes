# Notes CS 365
## 1/16/2013

### MIPS Instructions
**Primary Set**:
    - Add
    - Sub
    - And
    - Or
    - lw
    - sw
    - beq
    - bne
    - j
    
**Secondary Set**:
    - jr
    - jal
    - slt (set less than) 
    - andi
    - addi
    - ori 

####C to MIPS Example Translation
```
if (A[5] == A[6]) {
    s = s + 1;
    a = a + s;
}
else {
    A[5] = A[5] + 1;
    s = s - 1;
}
```

to 

```
lw $R20, 20($R12)
lw $
```

### 32-bit 
- Need 2^5 = 32
**R-Type**
And/Or Instructions:
```
    [opcode][5bit][5bit][5bit][00000][6-bits]

```
**I-Type**
Load/Store Instructions,
beq, bne, addi, andi, ori
```
    [opcode; >= 4bit][5bit][5bit][offset-byte: max 18 bit]
    [6bit][5bit][5bit][16bit]

```
**J-Type**
Jump (j) instructions:
```
    [6bit][26bit]
```

####For Exercise 1(a):

```
[6][5][5][16] I-type
[6][5][5][5][] R-type
[            ] I-type

--------------------
[lw-100011][01100][01010][0000 0000 0101 1010]
[add][][][][00000][]
[sw][][][]
--------------------
add = 0/20hex -> 0 = opcode, 20 = function 
[000000][01010][01110][01010][00000][00100000]

```
#### Exercise 1(b) to Machine Lang

```
bne:
    on green sheet: 5 hex
    [000101][0100][01001][0000 0000 0100 0000]
j:
    it is type J:
    [0000 10][26 bit for address]
    [0000 10][0xAABB4400] (need to cut bits because not 26bit)
    [0000 10][cut off left end and right end] 

```

## Homework #2 Due Wednesday 
