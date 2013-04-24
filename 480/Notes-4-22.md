# CS 480 Notes
# 4/22/2013

## Bloom's Heirarchy (Taxonomy)
- Evaluation
- Synthesis
- Analysis
- Application
- Comprehensive
- Knowledge

## Exam
- Based on critical thinking
- "Would you require 100% coverage testing"
    - Argue your claim 
- "Which QA tool would you use in this scenario"
- "Would you use inspection or unit testing, or static analysis to find defects of this type"
- "Give an example of a defect that is more eaisly caught by inspection than by system level testing"
    - Efficiency/Code Quality

## Program Analysis

- Find Defects
- Understand program better

- Static analysis is the form which reads the code
    - e.x. Compiler

- Dynamic analysis is the form which runs the code
    - e.x. Coverage Tester

## Inspection Recap
- Problems
    - Don't check output
    - Developer Time 
    - Limits on human understanding
    - Limits on human time/cost
    - Human errors
        - People are fallable

## Static Analysis
- A systematic exploration of program abstractions
- Find
    - Style Errors
    - Security Errors
        - Buffer Overflows
        - Unvalidated input
    - Resources
        - Memory Leaks
    - API Violations
        - Read file, close, try to read from close
        - Linux Bug:
            - Didn't reenable the save_flags
- Systematic: Ensure that everything of interest is explore. It should not be haphazard

- Abstraction: Track important abstractions, not everything

- AST Walkers
    - Walk through the abstract syntax tree (AST) looking for patterns that describe good or bad code.
        - Example: Ensure that all call to ``Logger.debug()`` are surrounded by an if statement that checks ``Logger.inDebug()``

- Grep is the simplest static analysis tool

- Control Flow Analysis
    - Considers the paths that a program will take as it is running
    - The analysis attempts to detect when the program is in the wrong state at the wrong time
        - Example: Ensure that when a method ends, the interrupt have been re-enabled if they were disabled
        - Essentially a FSA

    - The abstraction use includes states that the program might be in and simulate program counter

    - When branch is encountered, it explores each path
    - When branch comes back (end of an if) there are 2 options
        - Opt 1: Continue track paths separate
            - Expensive, what if 50 paths?
        - Opt 2: Join results 
            - Unknown state
            - Lose precision
        - Most chose 2, performance savings


### Precision in Static Analysis

- A sound analysis is one that has no false negatives; it is guarenteed to catch every bug

- A complete analysis is one that has no false positives, it is guarenteed that every bug it finds is actually a bug

- It is impossible to have an analysis that is both sound and complete


### Data Flow Analysis
- Considers not only the paths, but also the abstract states of the variables at each program counter

    - Example: NO NULL POINTERS

- The abstraction includes the abstract states for each variable in the program, plus the program ocunter. Variables change states independently of each other


#### Dealing with Method Calls In Flow Analysis
- Option 1: Perform a global analysis by entering into method calls and continuing to track state

    - Has same problems as branching
    - Requires developers to figure out fault

- Option 2: Modularize analysis by providing specifications for methods
    - Every method has preconditions and postconditions
    - Preconditions: assumed beggining of a method
    - Postconditions: must be true when end is reached
    - At method calls, precondition of method must be true, safely assume post condition after method returns
    - Allows analysis to analyze each method invidually

- Defensive Programming
    - check null everywhere
- Design by contract
    - make assumptions that people read documentation

### Other Kinds of Specifications
- Class invariants:
    - logical specs must be true upon entering
    - must be true upon exiting
    - can be temporarily broken in the middle
