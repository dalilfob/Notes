# CS 480 Notes
# 4/17/2013

## Integration Testing

- Phase where individual software modules are combined and tested as a group

- Occurs after unit testing
- Occurs before validation testing

- Takes input modules that have been unit tested
- Groups them in larger aggregates
- Applies test defined in an integration test

## Inspections
- Inspections are reviews of software artifacts
- The reviews can be a formal process or an informal one

## Formal Inspections
- An example formal review process
    - Fagan-style inspections
- Requires team of 3-7 people
- Team size larger for document reviews and smaller for code reviews
- Team members read the code in advanced
- Expect people to be able to review 150-200 LOC per hour, or 3-4 pages of code

- Team members have a meeting to discuss, and each member has a role:
    - Moderator organizes process and keeps everyone accountable.
        - Must ensure outcomes of the meeting happen
    - Recorder captures log of what is discussed
    - Reader presents the material to the group, cannot be the author
    - Author can describe intent of code and the reason for it
        - Keeps quiet during meeting

- Checklist
    - Style 
    - Common Bugs
    - Performance Implications
    - Maintainability
    - Scalability


## Informal Inspection
- An example informal review process

- Author sends path file (which shows a diff of the code) to a reviewer

    - Patch file should be as small as possible, preferably no more than 200 LOC

    - Larger changes should be broken into multiple patches

- Reviewer uses an outline tool to add comments

- Author makes the suggested changes or responds to the comments

- When reviewer is satisfied

    - Author cleared to commit code to repo

### Formal Inspection Review
#### Costs
- Dev time x 3-7
- Communication Overhead
- Burnout
- Checklist
    - Who is sitting down to write this
    - Maintainence 

#### Bugs
- Logical errors
- Missing Features, validity
- Style/Maintainability
- Documentation
- Scalability
    - Complexity analysis

#### Bugs Missed
- Race Conditions
- Usability
- Integration 
    - Only reviewing small piece
- Time dependent issues

#### Overlap
- Unit Testing, some

#### Cost to Fix
- Cheap to fix
- Early in process
- Location of fault

#### Lifecycle
- Before commitment

#### Stop Reviewing
- Checklist Complete
- Consensus
- Time is up (2 hours)

#### Intangible Benefits
- Familiarity with code base
- Shared Ownership
- Training
- Multiple Perspective


## Therac

- ``10^-11``
- ``4 x 10^-8``

- Where in the world are these numbers from? What are the units?

- 1976 software was written
- 1 guy, couldn't figure out his credentials
- Copy/Paste Code
- System Level Testing
    - Used for 2700 hours
    - What the hell...

- 1983 Saftey Analysis
    - Unitless crap numbers

- 1985 First accident, Kennestone
    - Is it possible to operate in electron mode without scanning 
        - Was told not possible

    - 1 month later, 2nd accident (June)
    - 1 month later, 3rd accident (July)
    - Added redundancy for 1 bit error, claims 5 order of magnitude improvement
    - 4th accident 
        - race condition
        - operator super fast at input now
        - Their response: physically remove up arrow...
    - 5th error
        - Entering in numbers, not in a valid state yet
        - Temporary state of invalidity, machine polling to check if valid
        - Keeps track of error: ``err++``
        - Error overflowed, went to 0, machine thought it was ok to go
        - Should have been boolean, would have been caught in code review

- Afterstory
    - Became radiation company again, selling radiation tech in Panama

## Reliability
- Realization that despite best efforts
    - Errors will happen

- Analysis of inherent risks in system

## Therac Review
- Fault
    - Potential Overflow
    - Potential Race Conditions
- Error
    - Overflow
    - Race Condition
- Failure
    - Radiation because of overflow
- Hazard
    - Death
    - Very Ill
    - Company looses money

## Risk Management
- If we cannot avoid risks entierly, we must consider how to mitigate them

- We can either be preventative or reactive

- Preventative mitigation would invovle preventing the faults and errors in the code

    - Inspections can identify faults before they enter production
        - Code review identifies faults

    - Testing identifies errors

    - Can use other coding practices and measurements ot prevent faults
    
    - System/Integration Testing
        - Identify errors that cause failures

- Reactive Mitigation invovles dealing with failures and hazards
    - Self-healing systems can dynamically adjust when failures are detected in order to avoid hazards
    - Fault tolerant systems are able to handle multiple errors and prevent them from causing systemwide failure

## Benefits v Inherent Risk 

- Benefits
    - Medical Treatment
    - Large Electric Grids
        - Telecom systems
    - End users directly working with systems
    - Electronic Descision Making Systems
        - High frequency trading systems
        - Self driving cars

- Inherent Risk
    - Radiation poisoning
    - Cascade Failure
        - Domino effect failure
    - User fraud
    - Fast Failure
        - Stock market crash
        - Working at speed of computer instead of human
