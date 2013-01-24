#Notes CS 365
## 1/18/2013

### Exercise

```
1010 1101 0010 1000 0000 0100 1011 0000

0000 0010 0100 1000 0100 0000 0010 0000
```

### I have no clue what the hell is going on here...

### Assembly Language vs Machine Language
- Assembly provides convenient symbolic representation
    - much eaiser than writing down numbers
    - e.g. destination first
- Machine language is the underlying reality
    - e.g. destination is no longer first
- Assembly can provide 'pseudo-instructions'
    - e.g. "move $t0 ..." 

### Mips Addressing Modes
- Features
    - Load-store (register-register) architecture
    - Simple addressing mode
- Modes 
    - Immediate addressing (e.g addi)
    - Register addressing (e.g. add,..)
    - Base addressing (e.g. lw, sw )
    - PC-relative addressing (e.g. beq)
    - Pseduo-direct addressing (j, ...)

### Addressing Modes

```
addi $R17 $R14 20

    Reg[R17] <- Reg[R14] + 20

```

> See slides for diagram 
