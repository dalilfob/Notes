# Final Review

## Design Process

### What is the Design Process?
- Identify relevant parts
- Identify patterns
- Make multiple versions
- Compare
- Verify functionality
- Verify QA

### How do you verify functionality?
- Check each requirement systematically. 
- Watch control flow and data flow. 
- Sequence diagrams.
- use cases

### How do you verify Quality Attributes?
- Extesnsible? Class Diagram
- Scalable? Object Diagram
- Security Holes? Threat Modeling

### What is CRC?
- Class, Responsibility, Collaboration
- Card system similar to UML
- coupling: collaboration
- cohesion: responsibility

### Wht are DSMs?
- Design Structure Matrix
- N x N matrix of dependencies

## Design Principles

### What are the Goals of OO Design?
- Extensiblity
    - ease of adding new functions

- Reuseability
    - ease of reusing code


### What are the metrics of OO design?
- *Cohesion*:
    - measure of how much a class is inter-related

    - high cohesion is more readable and reuseable

- *Coupling*:
    - measure of how classes depend on each other
    - low coupling is flexible and extensible

- *Correspondence*:
    - measure of how well requirements match the design

    - good correspondence 
        - minor requirements change require minor work
        - major requirements change require major work


### OO Design Principle Terms
- *Encapsulation*:
    - Bundling data and methods 

- *Information Hiding*:
    - Hide design decisions most likely to change
    - Hide algorithms, data formats, UIs
    - Use interfaces and abstractions

- *Abstraction*:
    - Describe essential features without inessential details

    - Collection > List > ArrayList

- *Inheritance*:
    - Reusing types/Subtyping
    - Parent/Child relation of objects

- *Polymorphism*:
    - Object has many types
    - Use type, don't know what concrete subtype

- *Substitution*:
    - change concrete type without affecting desireable properties

    - possible via polymorphism 

    - e.g suddenly use ArrayList instead of List

## Exam 1 Review

### What are false positives and fale negatives?
- False positive:
    - Flags error when there is no error
    - Consumes developer time tracking down "ghost" bug

- False negative:
    - NO Error flagged, when there is in fact an error

    - False confidence

### How does dnymaic analysis improve reliablity and prevent hazards in a running system?

Dynamic Analysis may be used on production code in order to determine where users are having problems. Dynamic analysis unearths runtime errors, UI errors, and etc. It resolves errors, and prevents failures and hazards.

### Identify 2 benefits of finding a defect with a static analysis tool as opposed to finding it with system testing.

- SA is systematic, you can use the same technique to trace through say control flow, whereas in systems testing it's specific

- Can track larger abstractions

- Does not require running code

### 4 stages of group dev

- Forming
- Storming
- Norming
- Performing

## Program Analysis

### What is a static analysis tool and what types of errors does it find?

- Systematic review of program abstractions
- Automated code review
- Finds
    - Security errors
    - API violations
    - Race conditions
    - Memory
    - Resource: null pointers, leaks


### What are sound and complete analysis?
- Sound:
    - no false negatives, finds all bugs

- Complete:
    - no false positives, all bugs are actually bugs

### Problems with static analysis
- Termination
    - Cover all loops/branches?
- Precision
    - Can't terminate without ignoring things

### What is Dynamic Analysis? What does it find?

- Analyze running program
- Code Coverage
- Performance Analysis
- Memory analysis
- Concurrency 
- Security
- Data gathering from live users

### What is Dynamic Analysis limited by?
- Costly/Slow
- User input
