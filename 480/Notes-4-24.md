# CS 480 Notes
# 4/24/2013

## Static Analysis Tools
- Find Bugs (Java) Demo

## Using Static Analysis in Industry
- False positives are defined by devs, not technical definitions

- Analysis tools must be customized for product/team

- Priority tied to enforcement mechanism
    - High: Fix all
    - Medium: Fix all new
    - Low: Cap on fixes

- Grass roots (everyone using tool)

- Incrementally add support

### Precision in Static Analysis
- Sound Analysis
    - No false negatives
    - Guarenteed to catch every bug
    - High False Positive rate

- Complete Analysis
    - No false positives
    - Guarenteed all bugs found are actually bugs
    - High False Negative rate
    - See: Covarety Tool (Berkeley)

### SA Tools
- PREFAST 
    - Microsoft's SAL language

## Hard Problems in Static Analysis
- Precision
- Termination
    - Can track in branch statements
    - How do you track in a while loop?
    - Halting Problem

- Aliasing & Pointer Arithmetic
- Modularity
    - performance issue
    - practical analysis are modular
- Side Effects

## Dynamic Analysis
- Analyzes the running program
    - Instrumentation
        - Can instrument code at compile time
            - e.g. Aspects
        - Can instrument code at run time
            - Requires hooks in VM
    - Can run code on specialized VM that monitors program

- Common usages
    - Code Coverage
    - Performance
    - Memory
    - Security and Prevention
    - Concurrency
        - Know race condition when unit test randomly fails
        - Race Condition: 2 threads executing, not blocking on accessing data (3 users go to withdraw from same account) 
        - Try all possible interleavings
        - ``synchronize`` keyword in java
    - Data gathering
        - Ebay: javascript to find when people closed browser
    - Determining invariants in code
        - Preconditions and postconditions
            - Autofind preconditions
            - Tool: Daikon

### Benefits Of Dynamic Analysis over SA
- Provides very precise data
    - No false positives 
    - Always possible to traceback error
    - Can use on production code
        - e.g. ebay dynamic analysis to check when browser closes

### Limitations of Dynamic Analysis
- Slower
    - Performance
    - Memory
- Requires working program
- Needs inputs
    - User inputs
    - Tests
- Requires tests
    - Normal useage
    - Exceptional usage
    - Good coverage

### LifeCycle Considerations
- After tests
- Can be: during productions
- During QA


## Combining Static and Dynamic
- Static analyize paths, imprecise
- Dynamic analyze few paths, precise

- Static to Dynamic
    - Identify inputs for dynamic

- Dynamic to Static
    - Use dynamic to identify specs for static
    - e.g. Diakon to generate annotations for preconditions
