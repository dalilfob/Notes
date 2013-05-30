# CS 480 Notes
# 5/29/2013

## Metrics

### TSP (Team Software Process)
- Metrics-based
- McCabe Complexity
    - Cycles in code
    - aka Cyclimatic Complexity
    
### CMMI (Capability Maturity Model Integration)
- Meta process
- Is a process improvement training and certification program and service administered and marketed 
- Stages
    - Initial
    - Managed
    - Defined
    - Quantitatively Managed
    - Optimizing
- 6 sigma is the equivalent for manufacturing engineering

### Estimation
- Ad-hoc (wild ass guess)
- SWAG (scientific wild ass guess)
    - 3 WAG
    - keep adding

- Past experience
    - Keep a log / portfolio
    - databse of time logs (what we thought, how much it took)
- Planning Poker (*Wideband delphi*)
    - Estimation by comittee
- Function Points
- COCOMO: 
    - ``effort = a * SLOC*``  (man month)
    - ``DevTime = c * Effort^d`` (month)
    - ``People = Effort / DevTime`` (man month)

### Tracking
- Burndown Chart
    - track velocity
    - sprint backlog
- EVT (Estimation Value Tracking)
- Gantt Chart
- Defect Trackers

## Requirements

- Ellicitation
    - Who are the stakeholders, and how do they influence the process
    - Contextual Inquiry
        - Scientific observation of the user
    - Domain Vocabulary

- Modeling
    - Persona
    - Scenario
        - paragraph-based
    - Use case
    - SRS (Software Requirement Specification)
        - pictures
        - bulleted lists
        - ACTIVE VOICE only
    - User Stories
        - Template of a single requirement
        - As a (role) I want (goal) so that (benefit)

- Validation
    - Requirements are:
        - Consistent
        - Traceable
        - Unambiguous
