# Notes CS 365
## 2/18/2013

### Data Hazard 
1. ALU results used by next
     - instruction ALU input
    
     ```
        add $R15, $R12, $R10
        or  $R16, $R15, $R10
     ```

- For add:
    - Immediate -> Reg -> ALU -> DM -> Reg
- For Or:
    - 2            3      4      5     6
    - Immediate -> Reg -> ALU -> DM -> Reg

- Forwarding unit
- Detection unit 


Change code to:

```
add $R15, $R12, $R10
lw  $R16, 0x100($R15)
```

- (4) DM output used by next 
    - ALU Input
    
    ```
        lw r15, ...(r10)
        add r12, r15, r10 
    ```

    - 15 has dependence
    - From after DM to same cycle (4) of add's reg

- (5) DM output used by DM input
    
