#Notes CS 365
## 1/9/2013

###Performance
How do you determine what is "better":


    Performance ~ Speed

User CPU Time
: Time dedicated to executing user's programming 

Execution Time
: user's CPU time


    Performance = 1 / (Execution Time) 


- The faster the time (smaller value), the better the performance

We use the **Performance Ratio** of the two machines


    (Perf A) / (Perf B)  = (1/Time A) / (1/Time B) = Time B / Time A


If ratio is 1 they have equal performance

**Note**: Books definition requires n to be **greater** than 1.0, if not,
flip the numer & denom (i.e. Perf B / Perf A) 

        A   B
    P1  10  6  20%
    P2  5   7  10%
    P3  4   4  50%

Weighted averages used frequently in this class

###Performance Continued

1GHz = 10^9 cycles per seconds

    Clock Cycle Time = 1 / Clock Rate = 1 / 2.5GHz = (1/ 2.5e9 cycles/sec)  
                     = 0.4e-9 sec = 0.4 ns
                     = 400 e -12 = 400 PS




