# CS 460 Notes
## 2/26/2013

### Course Map
- Basic Cryptography
    - Security objectives, mechanisms and specific algorithms

- Systems Security
    - Email & Web Security Techniques
    - Software Security
    - Malicious Software 

### Recap
- Differences between SSL and SSH
    - SSL: 443, SSH: 22 (ports)
    - SSL used with HTTP , to secure web traffic
    - SSH used to secure remote login (putty, or other ssh client)

- What is the relation between a certificate and a digital signature?
    - Certificate is nothing but the identity of the user + public key
    - Receiver uses private key to digitally sign something 

- What is the primary goal of key exchange?
    - To establish a shared secret (symmetric encryption key) 
    - We solved this problem via asymmetric key distribution 
    - Problem with asymmetric encryption is computational intensity 
    - Use asymmetric mechanism to exchange symmetric key information, then encryption application data via shared symmetric key -- this is done in a lot of actual security protocols 
    
- Describe key exchange mechanism using RSA vs DH schemes
    - RSA the public key leaves the user space and travels on an open channel to the receiver
    - DH is created individually on each machine and never crosses an open channel 


### Today's Topic
- Malware defintiion & classification 
- Virus & Worm
- Propogration methods (how it spreads)

### Malware 
- Missed definition....


### Classification
- Based on host program dependency
    - Viruses need a host program to infect
    - Worms and Torjans do not need a host progrma
- Based on replication capability
    - Viruses and worms replication
    - Trojans DO NOT have replication
    
- Difference between Worm and Trojan?
    - Trojan is a worm that does not replication 

### Classifications (cont..)
- Propogation mechanisms:
    - Mobile code
    - Drive By Downloads
    - Social Engineering Attacks
    
- Payload Actions:
    - Corruption of system or data files
    - Make system part of botnet, make zombie
    - Steal information from system 

### Viruses
- A piece of software that infects programs (host program)
- It can do anything that the host program is permitted to do
    - Executres secretly when host program is running
- Specific to operation system 
    - A virus that works in windows XP , probably will not work on Vista

### Virus Components 
- Infection mechanism
    - Means by which a virus spreads or propogates
    - Also referred to as the infection vector

- Trigger
    - Event or conditiont hat determines when the payload is activated or delievered
    - Sometimes known as a logic bomb 
    
- Payload
    ...

### A Computer Virus
- See Fred Cohen 

```
program virus:=
{1234567;

    subroutine infect-executable:=
         {loop:file = get-random-executable-file;
              if first-line-of-file = 1234567 then goto loop;
               prepend virus to file;
                }

    subroutine do-damage:=
         {whatever damage is to be done}

    subroutine trigger-pulled:=
         {return true if some condition holds}

    main-program:=
         {infect-executable;
              if trigger-pulled then do-damage;
               goto next;}

next:}
```

### How to check for viruses?
- Check file size 
    - This is no longer the best idea, but it was what was done in the 80s/90s 


### Compression Virus
- check slides

### Virus Classification-by Target
- Boot sector infector
    - infects a matser boot record or boot record and spreads when a system is booted from the disc containing the virus
    
- File infector 
    - infects files that operation system or shell considers to be executable
    
- Macro virus
    - Infects via macro or scripting code that is interpreted by  ...

- Multipartite virus
    - infects and spreads multiple ways


### Virust Classification By Concealment
- Encrypted virus
    - A portion of the virus creates a random encryption key and excrypts the remainder of the virus
- Polymorphic Virus
    - A variation mutates with every infection
- Metamorphic virus
    - ...

### See Chernobyl Virus

### Worms
- Independently infect and replicate
- Exploits software vulnerabilities in client or server programs
    - Can use network connections to spread from system to system
    - Also spreads through shared media (USB devices, DVD, etc) 
- Email worms

### See Stuxnet Worm 

### Drive By Downloads
- Exploits browser vulnerabilities to download and install malware on the system
     - When the user views a Web page controlled by the attacker
     
- Abuse the "trust" of users to assist in the compromise of their own systems
- Spam
    - unsolicited bulk email
    - significant 
- Trojan Virus
    - Seems helpful
    - . . . 

### Data Destruction
- Chernobly virus 
    - Windows 95 and 98 virus
    - Infects executable files and corrupts the entire file system when a trigger date is reached
    
- Klez
    - Mass mailing worm infecting windows 95 to XP systems
    - On trigger data causes files on the hard drive to become empty
    
- Ransomware
    - Encrypts hardware, then forces you to pay for the key 

### Real World Damage
- Causes damage to physical equpment
    - Chernobyl virus rewrites BIOS code
- Stuxnet worm
    - Targets specific industrial control system software
    - Siemens industrial control system with Windows operating system

### Bots
- Takes over another Internet attached computer and uses that computer ot launch or manage attacks

- Botnet: collection of bots capable of acting in a coordinated manner

- Uses:
    - DDOS: Distributed Denial of Service attacks
    - Spamming 

### Information Theft
- Keylogger
    - Captures keystrokes monitor sensitive information
    - Only returns information close to keywords ("login", "password")
- Spyware
    - Subverts a compromised machine to allow monitoring of a wide range of activity on the system 
    - Monitors keystrokes, web browsing history, steals temp files, etc 

### What is the simplest way to detect malware
    - Check file integrity via a hash 

### Generations of Anti-Virus Software
- First Generation: Simple scanners
    - Requires a malware signature to identify the malware
    - Limited to the detection of known malware

- Second Generation: Heuristic Scanners
    - Uses heuristic rules to searhc for probable malware instacnes
    - Another approach is integrity checking

- Third Generation: activity traps
    - Let virus run on controlled environment
    - Write patch for it 

### Host-Based Behavior Blocking Software
- Integrates with the operating system of a host computer and monitors program behavior in real time for malicious action
    - blocks potentially malicious actions before they have the chance to affect the system
    - Blocks software in real time so it has an advantage over antivirus detection techniques such as fingerprinting 

### Digital Immune System
...


