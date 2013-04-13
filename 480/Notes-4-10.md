# CS 480 Notes
# 4/10/2013

## Quality Assurance
- Logical Errors
- Edge cases
    - bad control flow
- Library misuse
- Race conditions / Dead Locks
- Memory Leaks
    - Segfault
- Usability
- Scalability
- Wrong features
- Performance
- Error-handling Errors
    - Silly things in catch blocks
- Security

### Terminology of Bugs
- Fault is a static problem in code (ex when entered data is invalid, incrementing a variable called errorCounter instead of setting it to 1)
    - Partial Array Out of Bounds

- Error is the dynamic problem at runtime (ex: variable errorCounter overflows and goes to 0)
    - ArrayOutOfBounds

- Failure is the problem of the system (ex. the machine, Therac-25, believes that is has valid data when it does not and shoots a beam of radiation)
    - Server shuts down

- Hazard is the resulting risk that actually happens (ex: a patient dies from radiation overdose)
    - business consequences (Walmart DDOS)

- Faults in dead code do not cause errors

- Multiple faults may cause and error together

- An error may not always result in a failure (The Therac-20 had the same fault, and the same error, but there was a hardware override that prevented the failure)

### The Cost of Defects
- 20% of modules cost 80% of defects, and 50% are defect free

- Cost of repair from injected requirements ranges from 5x to 100x

- Rule of thumb 3x-10x per phase in software lifecycle    

## Kinds of Quality Assurance
- Evaluation vs Preventative
    - Evaluation
        - Testing
        - Inspections
        - Program Analysis
    - Preventative QA attempts to stop defects in the first place
        - Getting requirements right
        - Getting design right
        - Implementing the design properly
- Verification vs Validation
    - Verification: Did I build the thing correctly?
        - product matches requirements
    - Validation: Did I built the right thing?
        - product accomplishes goal 

## Testing
-Direct execution of code on test data in controlled environment

- Important: reveals inconsistencies with specification program is wrong or whether the specification is wrong

### Goals of Testing
- Reveals specific failures
- Assess overall quality
- Verify contact (legal standards)
- Clarify specifications and learn about program

### Categories of Testing

- Visibility
    - Black Box: we do not see the internals of the code. Tests made to specifications
    - White Box: see internal control flow and structures. Guided by knowledge of code
    
- Automation
    - Manual testing: keyboard punding by a human
    - **Regression Testing**
        - Regression is the ability to re-run your tests at a later date
        - Benefits: prevents old bugs from recurring 
        - Low cost to store tests and run them again
        - Every time you fix a bug, write the test for it first so you can be sure that you fixed it and ran run it in regression
        - Problems: User Experience and User Interface
            - Internationalization
                - German testers are nitpicky


## Unit Testing
- What level of scale do we test in?
    - Entire system?
    - Subsystem?
    - Single Class?
    - Single Method?

- The unit is the level we test at
    - Industry:
        - generally refers to method-level unit testing 

- Unit testing is typically manual to create (then automated to run) and white box
    - Can be black box (API)
    - Semi-automated
        - Dev tools to generate unit tools

- Test Scaffolding
    - Scaffolding provides way to run the test
    - **JUnit** is a test scaffold
    - Driver
        - Component that calles the test 
    - Stubs
        - Components that test calls and return canned data

## Input Selection
- Equivalence Classes to select one input from each type of input
    - Example
        - List of 3 elements
        - List of 1 element
        - Empty list
        - Null list
        - List of lists








