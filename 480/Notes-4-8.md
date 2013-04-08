# Notes CS 480
# 4/8/2013

## Dev Tools Group Project
- 3 to 4 per group
- Submit to survey
- Require BitBucket account

## Team Dynamics
- Forming
- Storming
- Norming
- Performing

## Communication
- ``O(n^2)``

## Psychological
- Groupthink
- Social Loafing

## Organizational
- Multiple goals
    - What is each person's goal?

- Organizational Memory

- Attention Management

## Distribution
- Timezone 
- Cultural Awareness
- Physical Distance

## Student Group Problems
- Schedueling Problem
- Social Loafing
- Ignorance 
- Groupthink
- Multiple Goals

## Developer Tools
### Version Control
- Use HG (mercurial) version control in here
    - Initialize verson control software
    - Others can checkout 

- Locking vs Merging
    - What if 2 people commit at the same time
    - Locking
        - Ryan locks A as he edits it
        - Locks everywhere, others cannot commit
    - Merging
        - Multiple people can work on it, merges updates
        - SAME line of code -- CONFLICT, has to be hand merged

- Tagging
    - Version numbers
    - You can mark particular versions

- Branching
    - Can branch off to 2 people with a separate branch that runs parallel to the main branch
    - Example:
        - Release v. 1 and working towrds v. 2
        - Client needs v. 1 to be fixed, so branch off
        - Then merge that branch later down the line
    - Be careful of multiple heads
        - Everything should be merged back to TRUNK at the end

- Centralized vs Distributed Systems
    - So far we've been discussing centralized control systems
        - Everything on central server
        - Checkout from central server

- Distributed
    - Everyone has a copy of the repo
    - Commits locally, can make branches, etc
    - Ryan makes changes, David wants, David pulls from Ryan
    - David then updates from this pull

- Atomicity of Commits
    - Can rollback to a particular commit

### IDE
    - Debugger
        - Breakpoints 
        - Watch Window
        - Multiple Breakpoints
            - Breakpoints specific to threads
    - Refactoring

### Build Systems
    - Make (C++)
    - Ant (Java)
    - Maven (Java)

### Patches
    - Patch File
        - Diff between version control and your working file
