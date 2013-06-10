# 480 Notes
# 6/3/2013

## Agenda
- Final on MONDAY
    - Slanted to latter part
- Design due Friday


## Guest Lecture
- Software Processes:
    - Moderate Complexity
    - Tailored, series of tradeoffs

## Google Example

### QA
- Unit testing?
    - Yes

- Code Review?
    - Team level
    - Pair
    - Familiarity, move around a lot

- Blackbox Testing
    - Slow process
    - Most teams on 1 week release cycle
    - Requires testers (have few testers)
    - Maybe used

- Static Analysis
    - Lot of false positives
    - Security / Memory
        - Cross Site Scripting
    - Threading / Race Conditions
    - Maybe used

- Dynamic Analysis
    - Large user base
    - Works on running code
    - Load Testing
        - Expensive
    - Used sometimes:
        - Load tests
            - sparsly

- Metrics
    - Metrics serve as a pale proxy for what you want to know
    - Cyclimatic Complexity
    - Maybe used
        - Tools to track coverage
        - Do not track cylimatic complexity
        - Most things are automatically tracked
        - No decisions made off of these metrics
            - 90% coverage or bust!

### QA Tradeoffs
- Upfront vs Continous Costs

- Unit Testing
    - small tests, low cost, high assurance
    - Any more assurance is exponentially more costly


### Design/Architecture
- UML
    - Industry standard
    - People move around a lot
    - Cons:
        - Cost of creation
        - Complex and large company
        - Somewhat bad for communication
            - Diverse company, Astrophysicits won't know
    - Maybe used, informal diagrams

- Design Patterns
    - Restrictive
    - Maybe used

- Prototyping
    - Pseudocode
    - Hacked proof of concept
    - Cons:
        - Waste of time
        - Sometimes idea is far too large
    - Maybe used

- Validation
    - Reviews
        - Ask the smart people
        - Cons:
            - Expensive / Time Consuming
        - Pros:
            - Small cost for large project
            - Diverse population of input
    - Maybe used:
        - Beggining of brand new projects
        - Not used for small or repeated things

- Updating Doc
    - New person on team
        - Google generally makes new person do the update
    - When someone asks for it
    - Major Changes

    - Continuous or Never?
        - Continuous:
            - Service oriented, so if commonly used API, then need continous updates to documentation
        - Never:
            - Small team
            - No external pressures
            - Rapidly moving prototype


### Planning & Tracking
- Estimation
    - SWAG
        - For a prototype perhaps
        - Few external deadlines, don't need anything more than SWAG
    - Metrics
    - Group Estimation
    - Wide-Band Delphi (Planning Poker)

- Tasking
    - Project Manager
        - 3rd party deligation
    - Engineers Volunteering
        - Engineers are a pain in the ass
            - Appease them
    - Either is used, sometimes both

- Tracking
    - Burndown Chart
    - Gantt Chart
        - People, dependencies
        - Burndown on crack
    - List (Defect Tracker)
        - 90% of "do these things"
    - Mostly use lists
        - Few external deadlines
        - Less complex
    - CMMI
        - Not done
        - Expensive, complex, mainly used for external entites
