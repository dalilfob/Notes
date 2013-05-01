# CS 480 
# 5/1/2013

## Design Maintainence
- Code changes 
    - Feature Changes
    - Bugs
- Quality Attributes (non-functional attributes)
    - Flexibility
    - Reusability

- How do I know if a design is:
    - Flexible?
    - Reusable?

- Metrics
    - **Cohesion**:
        - Measure for how much a class is intra-related
        - How much does it relate to itself
        - Measure:
            - Bipartite graph
                - Visualize what methods use which fields
            - Note how closely related the fields and methods are and determine whether it maybe separated into classes
        - Low cohesion:
            - Bad
        - High cohesion:
            - Good

    - **Coupling**:
        - See: Type coupling
        - Measure for how much classes are inter-related
        - Class dependencies
        - Single changes cause domino effects
        - Measure:
            - How many times was class X referenced from Y
                - Naive approach
        - High Coupling = Bad
        - Could be tied to standard:
            - HTML vs Microsofts HTML
        - No coupling is also bad (how is that even OOP?)
        - ``void food (ArrayList<Integer> arr)``
            - Couplied to ArrayList
            - Should be coupled to List or Collection

        - Interfaces help with coupling!

    - **Correspondance*:
        - How much the design matches the requirements
        - Anticipation of future changes
        - Minor requirements changes should be a low cost in design 
            - Example: make text bold shouldn't take months
        - Major changes : high cost to design
        - Requires experience and practice to measure correspondance

- Design Principles
    - **Encapsulation**
        - Bundling together data and code that works on data
        - Methods in 1 C file and some global variables
        - Things together that go together

    - **Information Hiding**
        - Principle of hiding the design decisions which are most likely to change
        - Access modifiers, setters, getters
        - Can hide algoritms: ``sort()``
        - Hide entire data structures

    - **Abstraction**
        - Describe the essential features of a type withut the inessential details
        - Example:
            - Use List instead of ArrayList
            - Collection ``>`` List

    - **Inheritance**
    - **Polymorphism**
    - **Substitution**
