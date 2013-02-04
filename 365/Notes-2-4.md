# Notes CS 365
## 2/4/2013

### Project 1 Due Monday Feb. 11
- How to represent binary
    - String, object, array, etc
- Program input:
    - File, initialization, args NOT keyboard

> Hopefully these specifications will be on blackboard (?) 
    
### The Processor: Datapath & Control
- Simplified to contain only:
    - Memory-reference instructions: ``lw,sw``
    - Arithmetic-logical instructions: ``add,sub,and,or,slt``
    - Constrol flow instructions: ``beq,j``
    - May eaisly extend to additional instructions such as ``addi,jal...``
- Generic Implementation
    - Use the program counter (PC) to supply instruction address
    - Get the instruction from memory
    - Read registers
    - Use the instruction to decide exactly what to do 

### Implementation Steps
- Two common steps
    1. Instruction Fetch
        - Send the program counter (PC) to a memory to fetch the instruction
    2. Read operands
        - Read one or two registers using fields of the instruction to select the registers to read (except j instruction.) For a load instruction, we need to read only one register, but all other instructions (except j) requires two.
- Other actions
    - Depends on the instruction type
    - Could be summarized as: using ALU and processing the result

### More on Implementation Steps
- Arithmetic-Logical Instructions
    - Use ALU for opcode/function code execution
    - Write the data from ALU back to register
    - Example: ``add $R15, $R14, $R13``
- Memory-Reference Instructions
    - Use ALU for calculating effective address
    - Access memory for storing a word or loading a word
    - Example ``sw $R15, 0100($R20)`` 

- Branch Instructions 
    - Use ALU for comparison
    - Change the next PC based on the comparison
    - Example ``beq $R15, $R0, 0100``

### Description of Functional Units
- Two types of functional units:
    - Elements that operate on data values (combinational)
    - Elements that contain state (sequential)
    - Combinational circuits vs. sequential circuits (refer to CS210) 
- State Elements
    - Unclocked vs Clocked
    - flip-flop
        - outputs depend on present inputs and also on past inputs
    - Clocks used in synchronous logic
        - when should an element that contains state be updated?

### Clock Cycles
- Each triggered clocking
    - The choice of which edge cuases state change affects the implementation, but not the design concepts.

> See slide 7 (lect4a) for diagram 

### MIPS Implementation 
- An edge triggered methodology
- Typical execution:
    - read contents of some state elements
    - send values through some combinational logic
    - write results to one or more state elements

> See slide 8 for diagram 


### Book's Approach 
- First design
    - Use a single long clock cycle
    - The cycle should be long enough for the most complicated instruction, i.e. largest CPI
    - Characteristics 
        - Simple in design
        - Not practical due to low efficiency
- Second design
    - Multiple clock cycles
    - Pipelined implementation
    - More practical but more complex 

### Building a Datapath
- General methods
    - Analyze the steps for instruction execution
    - Build up the datapath for each step
    - Link them together using multiplexers 

### Step 1: Instruction Fetch (IF)
- Actions:
    - Fetch the instructions (read instruction memory)
    - Increment ``PC = PC + 4``
- Building Blocks
    - Instruction memory
        - state element for storing instructions,r ead only
    - PC
        - State element, keep the address of the instruction
   - Adder 
        - To increment the PC

### Building Blocks for IF

> See diagram on slide 12 and 13

### R-Type Instructions
- Components invovled
    - Register file and ALU
- Functions
    - Read two registers and write one register 

### Register File

> Diagram on slide 15 

### Register File, Write, R-Instruc.

> Slides 15-18 are diagrams 

- Decoder (5 in, 2^5 out) 
- Instruction memory is read only 
- Data memory is read/write 

### Load and Store Instructions
- Components invovled
    - Registers, ALU, data memory, and sign extension
- Functions 
    - Use ALU to compute memory address
    - Note: sign extension needed for adding offset (16-bit) to register value (32-bit) 
    - Value from memory writes back to register 

#### Example

```
sw r16, 0x1008(r20) 
```

1. IF
2. Read r20, r16
3. Memory adder <-- ``R20 + 0x1008`` 
4. sign extension and things...

> See 'More building blocks' slide  (20) 
