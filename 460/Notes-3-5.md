# Notes CS 460
## 3/5/2013

### OS Security 

### Recap
- Substitution vs Permutation:
    - Sub bytes/characters 
    - Permutation = transformation, moving characters (change position)

- You need to encrypt a key (256 bit) and some data (2 GB). Between symmetric and asymmetric encryption, which one will you choose to encrypt the key and which one will you choose to encrypt the data? Why?

    - RSA for the key and AES for the 2GB data 
        - RSA is computationally intensive

### Operating System
- Each layer of code needs measures in place to provide appropriate security services

- Each layer is vulnerable to attack from below if the 

### BIOS
- Basic Input Output System 
- Onboard controllers are physical attack vectors
- Upper levels security dependent on lower level security 

### Example "Core" Kernel
- See slides 

> Note: Check integrity with a hash

### Linux/Unix Security
- application and service configuration
    - most commonly implemented using separate text files for each application and service
    - generally located either in the /etc directory or in the installation tree for a specific application


### Why is it important to check where a program is installed?
    - Is it secure from tampering / viruses

### Linux/Unix : Users, Groups, and Permissions
 - Permission using ``ls -l`` are listed as:
    - Owner/Group/Everyone Else

```
-   in any position means that flag is not set
r   file is readable by owner, group or other
w   file is writeable. On a directory, write access means you can add or delete files
x   file is executable (only for programs and shell scripts - not useful for data files). Execute permission on a directory means you can list the files in that directory
s   in the place where 'x' would normally go is called the set-UID or set-groupID flag.
```
- At the very root level, unnessary permissions are the reason for most malware attacks 
    - Viruses latch onto programs, and assume their same privelages 

- When hackers use their remote scanning features, they perform a list ``ls -l`` and check the permissions of potential attack targets 

#### Example Windows System
- User1: No admin privlages
- User2: Admin privlages
- Have 3 Drives:
    - C: System
    - D: Data
    - E: Data2


Does User1 have access to partition D and E?
    - By default USER1 has access
    - USER2 (ADMIN) must explicitly prevent permissions
    - NTFS permission control has (~6) permissions:
        - Full Control
        - Modify
        - Read & Execute
        - Read
        - Write
        - Special Permissions

### Windows Security
- Configuration is stored in Registry
- Attacks may be persistent if Registry is maliciously modified 
- Check out **Microsoft Baseline Security Analyzer** 

### Disk Layout & Key Storage

Windows Partition Contains:
    - Encrypted OS
    - Encrypted Page File
    - Encrypted Temp Files
    - Encrypted Data
    - Encrypted Hibernation File

What's the Encryption Key?
    - SRK (Stroage Root Key) contained in TPM
    - SRK ecnrypts VEK (Volume Encryption Key) protected by TPM/PIN/Dongle
    - VEK stored (encrypted by SRK) on hard drive in Boot Partition

Boot Partition:
    - Contains MBR, Loader, Boot Utilities (Unencrypted, small) 

#### How is this vulernable?
    - The decrypted key will be put in memory by the BIOS ...and this was attacked 
    - This is why it's extremely important to check where things are being stored 

    - Keys: 2046 bit RSA
    - Data: 256 bit AES 

### File System Encryption (EFS)
- See "Encrypting File System" on wikipedia for the diagram 

#### EFS vs Disk Encrpytion
- Which one is better: Disk Encryption or File System Encryption?

    - In Disk encryption, the entire volume is decrypted, if during runtime you get a virus, and encrypt it again...you just encrypted the virus
    
    - In EFS each file gets its own key 

> They're complements of each other, can use both 

### FINAL EXAM COMING SOON, GET OWNED HOMIE
