#Notes CS 365
## 1/11/2013

###Formulas
```
Perf = 1 / execution time
```
```
Execution Time = IC * CPI * (1/ clock_rate)
```
```
MIPS = clock_rate / (cpi * 10^6)
```

###MFLOPS
- MFLOPS (millions of floating point operations per second)
  - 1 floating point operation may be executed by 1 instruction (with about 30-50 cycles or even more.)
  - 1 floating point operation may be simulated by a number of integer instructions (say 20 - 30 integer instructions with each integer instructions executed by 3-5 cycles, for example.)
  - Which way has better MIPS? Is the one with higher MIPS has better performance?
 
###Benchmarks
- Performance best determined by running a real application
  - Use programs typical of expected workload
  - Or, typical of expected class of applications
    - e.g. compilers/editors, scientific applications, graphics, etc
  - Small benchmarks
    - Nice for architects and designers
    - easy to standardize
    - can be abused
  - SPEC (System Performance Evaluation Cooperative)
    - comapanies have agreed on a set of real program inputs
    - valuable indicator of performance (and compiler technology)
        

