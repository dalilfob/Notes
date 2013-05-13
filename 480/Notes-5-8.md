# CS 480 Notes
# 5/8/2013

## Template Method
- Participants
    - Abstract Class (Application)
        - Define primitive operations  that concrete subclasses define to implement steps of an algorithm

        - implements a template method defining skeleton of algo. Calls primitive operations as well as operations defined in AbstractClass

- Concrete Class (MyApplication)
    - implements primitive oprations to carry out subclass steps

- Collaborations
    - ConcreteClass relies on AbstractClass to implement invariant steps of algo

- Consequences
    - Fundamental for code reuse
    - Particularly important in class libraries

## Decorator Pattern
- Applicability
    - Use Decorator
        - to add responsibilities to individual objects dynamically and transparently 
        - for responsibilities that can be withdrawn
        - when extension by subcalssing is impractical
            - large number of independent extensions are possible
            - class definition may be hidden 

- Participants
    - Component (Visual Component)
        - defines interface for objects that can have responsibilities added to them dynamically
    - Concrete Component (TextView)
        - defines an object to which additional responsibilities can be attached

    - Decorator
        - Maintains a reference to component obects and defines an interface that confroms to Component's interface

## AbstractFactory

- Concrete subclass Widget Factory for each look-and-feel standard

- Applicabilitiy
    - A system should be independent of how it sproducts are created, composed, and represented
    - A system should be configured with one of multiple families of products
    - A family of related product objects is designed to be used together
        - enforce this constraint
    - Provide class library of products
        - reveal only interface, not implementations

## Command Pattern
- Participants
    - Command
        - Declares an interface for executing an operation
    - Concrete Command (PasteCommand, OpenCommand)
        - Defines binding between Recevier object and an action
        - Implements execute by invoking corresponding operations on Receiver
    - Client (Application)
        - creates ConcreteCommand object and sets receiver
    - Invoker (MenuItem)
        - Asks command to carry out request
