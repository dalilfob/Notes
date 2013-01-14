# Notes CS 365
## 1/14/2013

##Lecture 2a: MIPS Instruction Set

### Instructions
- Language of the Machine
  - Different machines have different insturction sets
  - I speak Spanish to God, Italian to women, French to men, and German to my horse

- Stored Program Concepts 
  - Instructions and data of many types are stored in memory as numbers

### Stored Program Concept
- Instructions are bits
- Programs are stored in memory
  - To be read or written just like data
  ``
  processor <-> Memory
  ``

- Program Execution
  - Fetch an instruction and put into a special register
  - Execute the instruction (Bits in the register "control" the subsequent actions)
  - Fetch the "next" instruction and continue 

### Cycles of Instruction Execution
- Instruction Fetch: obtain instruction from program storage
- Instruction Decode: locate and obtain operand data
- Execute: Compute result value or status
- Result store: deposit results in storage
- Next instruction: determine successor instruction

### Instruction Set Architecture
- Instruction set design or ISA: SW/HW interface
- We'll be working with the MIPS instruction set architecture
  - Microprocessor without Interlocking Pipe Stages (MIPS)
  
### Basic Issues in Instruction Set Design
- Fundamental operations
  - Arithmetic: add, sub, ...
  - Logical: and, or, ...
  - Memory access: load, store
  - Branch, branch if equal if not equal jump, ...

### MIPS Architectural Features
- Registers
  - 32 32-bit general purpose registers, named `` $r1, $s1, $t1, ... `` (see convention later)
  - `$r0` always 0
  - 32 FP registers (to be discussed later)

- Memory
  - Memory address: 32 bit; memory content: byte addressed
- Load-store & RISC architecture
- Basic operand addresses are 32 bits long
- Basic operands, like integers, are 32 bits long
- In general case, instruction could reference 3 operands
  - e.g. `A <- B + C` 

#### Load/Store Architecture

add a,b,c
```
load $r10,b
load $r11,c
add $r12,$r10,$r10
store $r12,a
```

### Memory Organization
- Viewed as a large, single-dimension array, with an address
- A memory address is an index into the array
- Memory is byte-addressed, meaning that the index points to a byte of memory
- Bytes are nice, but most data items user larger "words"
- For MIPS, a word is 32 bits or 4 bytes
- Memory size (for direct access in instructions)
  - 2^32 bytes with byte address from 0 to 2^32 - 1
  - or 2^30 words with addresses 0,4,8,...
- Words are aligned
  - Must start with last 2 bits as 00 (multiply of 4) 
  - Double word: multiple of 8 (ends in 000) 

### Binary Representation
- Bits are just bits (no inherent meaning)
  - Conventions define relationship between bits and numbers/instructions
- Numbers
  - Binary numbers (base 2)
  - 2's complement representation

### Hex Numbers
- Hex Numbers 
  - 0-9, A-F, (in 4-bit binary: 0000 to 1111)
  - better writability
- Binary -> Hex
  (take each 4 bits and convert) 

### Arithmetic and Logical Instructions
- Operations: add, sub, ..., and, or, ...,
- All instructions have 3 opeands
- Operand order is fixed (destination first)
- Operands must be registers, only 32 registers provided
- Example:
```
  C code: A = B + C
  MIPS code: add $s0, $s1, $s2
```
### Data Transfer Instructions
- Transfer data between memory and register
  - Load: from memory to register
  - Store: from register to memory
  - lw & sw: load word and store wrod

- Feature sof load-store (i.e. register-register) architecture

### Decision Making Instructions
- Branch
  - alter the control flow
  - i.e., change the "next" instruction to be executed
- MIPS conditional branch instructions:
```
  bne $t0, $t1, Label
  beq $t0, $t1, Label
```

###MIPS Unconditional Branch Instructions
```
  j address or j label (jump)
  jal address or jal label (jump and link)
  jr Register (jump register)
```

- J Loop
  - unconditional jump to an instruction marked by a label Loop or an address that starts the instruction labeled by Loop
- Jal Swap
  - save and return address NPC, i.e. PC + 4 in $ra and then jump to swap. Used for function call
- JR $ra31 (or jr $ra)
  - jump to the address saved in the register. Used for call return 
