# CS 480 Notes
# 4/15/2013

## Half Coverage

```
if(a)
    x();
else
    y();
if(b)
    v();
else
    w();
```

Can cover ``a and b`` as well as ``!a and !b`` but this is half line coverage. Could also include ``a and !b`` and ``!a and b``


## Test Driven Development

- Write tests first, then develop your code
    - Run tests, they should fail 
    - ensures something is being tested
    - write code that makes it pass
    - Benefits
        - brainstorm implementation
        - clear direction + specifications
        - test more edge cases
    - Side Note: Dev-In-Test (position to test software)
- Prerequisites
    - Specifications
    - Method Header + API


- How to evalute which testing paradigm to follow?
    - Cost
    - Bugs Found
    - Bugs Missed
    - Technique Overlap
    - Cost to Fix
    - Lifecycle
    - Stopping Point

- Evaluating Unit Testing
    - Cost
        - Time of dev writing unit test
            - sunk cost (high)
        - running tests
            - recurring cost (low)
        - maintaining tests
            - recurring cost (low)
    - Bugs Found
        - logical errors
        - Edge cases
        - Missing Functionality
        - Wrong Output
    - Bugs Missed
        - Usability
        - Nondeterministic
            - race conditions
            - random numbers
        - Scalability/Performance
        - Missed Feature
    - Technique Overlap
    - Cost to Fix
        - Low
    - Lifecycle
        - Right-before
        - Right-after
    - Stopping Point
        - Cost Benefit Analysis
        - Diminishing returns (bugs found vs time)
        - Coverage (% covered)
        - Business Drivers

## Test Plan

- How are we going to test
- Who is testing
- What are we testing
- When to test and when to stop
- How is the testing going to happen
- Why is this a good set of tests

## Parts of Bug Report
- Priority: 1-5 rating generally
    - How important is the bug?
    - Does it need to be fixed right away?

- Severity
    - How severe is the result of the bug
        - Blocker (doesn't compile)
        - Critical (crashes)
        - Major (big hinderance)
        - Minor 
        - Trivial (annoying looking)

- Status
    - What is the current status of the bug int he lifecycle? Possible stages:
    - Unconfirmed
    - New/Confirmed
    - Assigned/Accepted
    - Resolved
    - Reopened
    - Verified
    - Closed

- Resolution
    - Fixed
    - Won't fix
    - Works for me
    - Duplicate
    - Invalid
    - Dependencies

## Best Practices for Reporting Bugs
- Provide reproduction steps
    - Smallest test case possible when reproducing bug
    - Help root cause analysis

- Be non-antagonistic
    - Don't blame

- Avoid using defects in performance evaluations

- Find and fix related bugs

- Identiy the root cause
    - How could this bug have been prevented?
    - Could we have discovered it earlier?
    - Are there other related bugs?
    - If there are fix them! Don't make the tester find them all one-by-one
