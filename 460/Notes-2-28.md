# CS 460 Notes 
## 2/28/2013

## Software Security

### Bank of America Example

```
You            BoA
---           -----
Application   Application } OS
Transport     Trasport \\
Network       Network  \\ NS, kernel
```

- HTTPS only guarentees you're secure in the Network Traffic level.

- You are safe in the Transport/Network to Network/Transpor to zone, meaning if someone runs a packetsniffer, they'll at best receive encrypted packets 

- You are still vulernarable to a keylogger (not safe on Application level) 

### OSI Model
- (7) Application: Network process to application
- (6) Presentation: Data representation, encryption/decryption, convert machine dependent data to independent data
- (5) Session: Interhost communication, managing sessions between applications
- (4) Transport: end-to-end connections, reliability and flow control
- (3) Network: Path determination and logical addressing 
- (2) Data Link: Physical Addressing
- (1) Physical: Media, signal binary transmission 

### Penango & HTTPS
- Do you need to use HTTPS if you use Penango?
    - Penango does not encrypt your e-mail subject
        - In security, everything is important (tie up loose ends)
    - Penango does not secure login information

### DKIM vs S/MIME

- DKIM was implemented to protect against spoof email by signing at the domain level 

> What SHOULD have happened is all intermediate mail servers that route your emial, should sign the message

- DKIM operates at the domain level 


### Course Map
- Basic Cryptography 
    - Security objetives, mechanisms and specific algorithms

- System Security
    - Email & Web Security
    - Software Security
        - Malicious Software

### Security Vulnerabilities of SW
- Buffer Overflow
- Invalid Input
- Untrusted inter-process communication
- Insecure file operations
- Improper Access Control 

### Buffer Overflow
- Programming errors when a process attempts to store data beyond limits of a fixed-size buffer

- Overwrites adjacent memory locations
    - locations could hold other program variables, parameters, or program control flow data 

- Buffer could be located on the stack, the heap, or in the data section of the process 

- Consequences:
    - Corruption of program data
    - Unexpected transfer of control
    - Memory access violations
    - Execution of 3rd party code 


```
Mem
-----           --------
|   |           |      | 
|   |           |      |ui
-----           --------

            ---------
            |  HD   | <-- Exe
            ---------
```


- Essentially, give a buffer more input than it can take in order to overwrite other parts 

### Invalid Input
- Watch Out
    - Text input fields, commands passed thorugh a URL used to launch the program
    - Audio, video, or graphics files provided by users or other processes and readby the program
    - Any data read from an untrusted server over a network

- Attackers will try all sorts of malformed input 


### Inter-process Communication
- Separate processes--either within a single program or in two different programs--sometimes have to share information

    - Common methods include using shared memory or using some messaging protocol, such as Sockets, provided by the operating system 

- These are often vulnerable to attack
    - When writing an application, you must always assume that...

### Insecure File Operations
- Examples of insecure file operations include:
    - writing to or reading from a file in a location writable by another user
    - failing to make the right checks for the file type device ID, links, and other settings before using a file
    - failing to check the result code ...

### Access Control
- Access control is the process of controlling who is allowed to do what
- Privelages, also called permissions
    - are access rights granted by the operating system controlling who can do what
- Of particular interest to attackers is the gaining of root privelages
    - The unrestriced permission to perform an operation on the system 

> Rule of least privelage

### Brief History of Buffer Overflow Attacks

- 1988: The Morris INternet WOrm uses a buffer overflow exploit in "fingerd" as one of its attack mechanisms

- 1995: A buffer overflow in NCSA httpd 1.3 was discovered and published on the Bugtraq military....

### Stack Frame with Functions P and Q
```
----
stack



-----
heap
-----
```

- Heap is generally used for dynamic memory allocations
- Otherwise main functions stay on the stack 

If we have a program:

```
p() {
    q(param1, param2);
}
```

It will be placed as:

```
P: Return Address
   Old Frame Pointer
   param 2
   param 1
   ---------------
Q: Return Address in P
   Old Frame Pointer   <-- frame pointer
   local 1
   local 2             <-- stack pointer 
      |
      |
      |
      v
```

- Why are buffer overflow exploits still a big issue in the age of OOP?
    - You can never ignore C or C++, because the core of operating systems of written in C
    
> Should know: C, Python/Perl, Java/C#, PHP/ASP/Ruby 

- For stack smashing, the goal is to be  able to replace the return address with your own memory location

### Shell Code
- Code supplied by attacker
    - Often saved in buffer being overflowed
    - Traditionally transferred control to a user command-line interpreter (shell)
- Machine Code
    - Specific to processor and operating system
    - Traditionally needed good assembly language to create
    

- Need to write shell in C -> Assembly -> Machine Code


### Stack Overflow Variants 
- Target Program Can Be:
    - A trusted system utility
    - Network service daemon
    - Commonly used library code
- Shellcode functions
    - Launch a remote shell when connected
    - Create a reverse shell that connects back to the hacker
    - Use local exploits that establish a shell 
    ...


