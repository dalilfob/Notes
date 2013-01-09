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


Example: 

    Execution Time = 100 x 10^6 * 4 * 400ps = 16 e 10ps = 0.16seconds

**Formula**


    Execution Time = IC * CPI * CCTime
                   = (IC * CPI) / Clock Rate


###Performance (Slides)
- Measure, Report, and Summarize
- Making intelligent choices
- See through marketing hype
- Key to understanding uderlying organization motivation

####Example
Suppose we have two implementation sof the same ISA. Machine **A** has a clock cycle time of 250ps and a CPI of 2.0 for one program, and machine B has a clock cycle time of 500ps and a CPI of 1.2 for the same program. Which machine is faster for this program, and by how much?

    Perf A   Time B   (IC_B * CPI_B * CCTime_B)
    ------ = ------ = ------------------------- 
    Perf B   Time A   (IC_A * CPI_B * CCTime_A)

     =  1.2 * 500
        ---------
        2 * 250

*Note*: IC_A = IC_B , therefore they cancled out in the above formula

####Example 

Our favorite program runs in 10 second son computer A, which has a 4GHZ clock. We are trying ot help a computer designer build a new machine B, that will run this program in 6 seconds. The designer can use new (or perhaps more expensive) technology to substantially increase the clock rate, but has informed us that this increase will affect the rest of the CPU design, causing machine B to require 1.2 times as many clock cycles are machine A for the same program. What clock rate should we tell the designer to target?

    Perf B   Exe Time A   IC_A * CPI_A * CCTime_A
    ------ = ---------- = ----------------------- 
    Perf A   Exe Time B   IC_B * CPI*B * CCTime_B

    CCTime = 1 / clockrate

   10    IC_A * CPI_A * (clock_rate_b) <-- x
   -- =  -----------------------------
   6     IC_B * CPI_B * (clock_rate_a) <-- 4GHz

Information:

A
:10 sec
:4 GHZ
:n cycles

B
:6 sec
:x GHZ
:1.2 n cycles

    IC_A * CPI_A = n cycles
    IC_B * CPI_B = 1.2 n cycles

    then solve for n

###MIPS (Millions of Instructions Per Second)
- How to calculate MIPS?
  - Recall
    - Execution_time = IC * CPI * Clock Cycle Time
    - For MIPS, Execution time = 1 second, Instructions in millions (n * 10^6), clock cycle time = 1 / clock rate
  - Therefore: 1 second = n * 10^6 * CPI * 1/clock_rate
  - MIPS = cock_rate / (CPI * 10^6)
- Good News: MIPS independent of IC
- Bad News: Machine A has a higher MIPS than Machine B not necessarily means A executes a particular program faster than B

    MIPS = clock_rate
           ----------
           (CPI * 10^6)

####Example
Facts
- A program compiled to 10^12 instructions on **A** with CPI = 2
- The same program compiled to 10^11 instructions on **B** with CPI = 3
- **A** clock rate is 4GHZ , **B** Clock rate is 3 GHZ

    MIPS_A = 4e9 / 2e6 = 2000
    MIPS_B = 3e9 / 3e6 = 1000

    Exe_A = 10^12 * 2 *  (1 / 4e9) = 500
    Exe_B = 10^11 * 3 * (1 / 3e9) = 100

###Summary of Performance
####Important Formulae

    Execution Time = IC * CPI * Clock_Cycle_Time


    Performance = 1 / Execution_Time
    

    MIPS = IC / (execution_time * 10^6)


    MIPS = Clock_rate / (CPI * 10^6)
