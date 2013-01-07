#CS 411 Compilers and Interpreters
## 1/7/2013

##Course Description:
- Chapters 1-6
- CS 311 (Languages and Automata) 


## Lecture Notes:
### What is a compiler?

  source program->compiler(a program with input and output) -> syntactically
  and semantically correct -> object code

  if compiler NOT syntatically correct -> error message
  
### Source Program:
- Lexical analysis
- Syntax Analysis
- Semantic Analysis
- Intermediate Code Generation
- Code optimization
- Assembly -> Object Code

####Lexical Analyzer (Or Scanner)
- Scan through input file, chop input into tokens
- Save identifiers into symbol table

  Tokens = {id, assignop, addop, mulop...num}  
  IDENTIFIER_regex = [_a-zA-Z][_a-zA-Z0-9]*
  UNSIGNED_regex = [1-9][0-9]* | 0 

Output: Tokens

####Syntax Analyzer(parser)
- Build up the parse tree (parse tree = graphical representation of CFG)
Example:
  CFG:
  <AS>  -> id assignop <EXP>
  <EXP> -> <EXP> + <EXP>
        -> <EXP> * <EXP>
        id |
        num

(Draw a derivation tree for "position = initial + rate * 60")

Output: Parse Tree

####Semantic Analyzer
- Define/Determine the meaning of the parse tree
- Perform TYPE checking
Example: if rate is a real number:
  60 -> 60.0

Output: Annotated Parse Tree

####Code Generator
- Generate 3 addr instructions from annotated parse tree

  temp1 = intToReal(60)
  temp2 = id3 * temp1
  temp3 = id2 + temp2
  id1 = temp3

Output: 3 Address Instructions

####Code Optimization
- Generate efficient code in terms of 
 - Storage requirements
 - Computation Time

  temp1 = id3 * 60.0
  id1 = id2 + temp1

1. Local improvement
 - Constant folding
  x = 10 * 2 [folded to]=> x = 20
 - Strength Reduction
  x * 2 [replaced]=> x + x
  x **2 [replaced]=> x * x

2. Global Improvement 
- Data flow analysis for loop optimization
