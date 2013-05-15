# Notes 450
# 5/15/2013

## Design Patterns

### Strategy Pattern
- Essentially use interface 
    - Basic Polymorphism

### Singleton
- Single instantiation of the class
- Essentially a global class
- Call ``static singleton getInstance()`` returns same object to everyone
- Abused as **global variable**

> Do not use patterns to excuse bad code
> Do not use patterns for the sake of patterns

## Design Exercise
- Midterm exam questions
- Practice design patterns or fail

### Naive Approach To Design Patterns
- Nouns:
    - classes
- Verbs:
    - methods
- Proper Nouns:
    - objects

#### Nounified Verbs
> This makes no sense from an english standpoint, no clue what she's talking about

- Commands
- Adaptor
- Decorator
- Observer
- Visitor

> This is a very confusing analogy

### Approaching Designs
- Find Patterns
- Make multiple designs
- Compare tradeoffs
- Identify assumptions/information hiding
    - what never changes
        - put in interface
    - what definitely changes
        - put behind interface
- CRC (Class Responsibility Collaboration)
    - Identify
        - Cohesion
        - Coupling
- Verify
    - Functionality:
        - Walk through requirements
        - How are objects created
        - Check normal and exceptional behavior
    - QA
        - extesnsibility
