# Therac 25

## About

- Radiation Therapy Machine
  - Therac 6, Therac 20
  - Invovled in 6 accidents
    - 1985
    - 1987
- Massive radiation overdose (100x)

- Electron beam therapy 
    - low doses 5 Mev to 25 Mev
- Megavolt X-Ray
    - Xrays 25 Mev

- No hardware interlocks
- Software interlocks failed because of race conditions
    - 1 byte counter in a testing routing frequently overflowed
        - if operator provided manual input to machine at precise moment of counter overflow:
            - INTERLOCK WOULD FAIL

- High powered electron beam struck 100x intended dose

## Software Engineering

- Documentation 
    - Not an afterthought

- Quality Assurance
    - Establish standards

- Simple Design

- Error/Debugging Routine
    - How to get information errors should be established
    - software audit trails

- Testing
    - Extensive testing
    - Formal analysis
    - System testing alone is wtf-worthy

- Saftey-Analysis
    - Naieve assumption of software reuse & legacy code (Therac 20)

- Social Responsibility

- Government Oversight
    - WTF FDA!?

    
