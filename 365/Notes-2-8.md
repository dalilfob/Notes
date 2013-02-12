# Notes CS 365 
## 2/8/2013

### Control Design

#### Control
- Selecting the operations to peform (ALU, read/write, etc)
- Controlling the flow of data (multiplexor inputs)
- Information comes from the 32 bits of the instruction
- Example:

```
add $R8, $R17, $R18
```

- Instruction format:

```
000000 10001 10010 01000 00000 100000
```

- ALU's operation based on instruction type and function code  
