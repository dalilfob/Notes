#CS 460 Secure Communications
## 1/8/2013

    Note: Textbook Required

###Goal of the Course

- Developing a security mindset
  
  - security as it applies to people's interaction with the digital world

- A very broad area
 
  - Some fundamental topics will be covered in this course
 
  - Topics such as web & cloud security in ... (can't see)
    

    Goal:  Always think about security from inception

### A possible pathway..
- This course
- Security+ certification during the summer
- Advanced security course in fall

###The CIA Triad
- Confidentiality
  - Data confidentiality
  - Privacy


        Secure from ...


- Integrity
  - Data integrity
  - System Integrity
- Availability

###FIPS PUB 199
- Federal information processing standards PUBlication

- *Confidentiality*: preserving authorized restructions on information access and disclosure
- *Integrity*: Guarding against improper information modification or destruction including ensuring information
- *Availability*: ensuring timely and reliable access to and use of information

###Beyond CIA
- Authenticity
  - The property of being genuine and being able to be verified and trusted

- Accountability/Provenance/Non-Repudiation
  - The security goal that generates the requirement for actions of an entity to be traced uniquely to that entity
    

        Can I find out how f***ed my s*** up?


- Trust and social engineering

###Vulnerabilities & Threats
- Vulnerabilities
  - Flaw or weakness in system/data/user
  - Example:
    - Leaky (absense of confidentiality guarentee)
    - Corrupted (absence of integrity guarentee)
    - Unavailable or very slow (loss of availability guarentee)

###Threat 
- Can't see 

###Attacks
- Attacks (threats carried out)
  - Passive: does not affect system resources
  

        Reading/Capturing information between two points


  - Active: attempt to alter system resources or affect their operation


        Changes information between two points


  - Insider: initiated by an entity inside the security parameter


###Unauthorized Disclourse
- Exposure: Sensitive data are directly released to an unauthorized entity.
- Interception: An unauthorized entity directly accesses sensitive data traveling between authorized sources and destinations
- Inference: A threat action whereby an unauthorized entity indirectly accesses sensitive data ( but not necessarily the
data contained in the communication) by reasoning from characters or byproducts of comminications.

    How to think about security...

###Deception
- Masguerade: An unauthorized entity gains access to a system or performs a malicious act by posing as an authorized entity...

...

###Disruption
- Incapacitation: Prevents or interrupts system operation by disabling a system component


    DDOS, etc, put system out of network


...

###Usurpation
- Misappropriation: An entity assumes unauthorized...
...

###Categorize?
- Can you categorize the attacks in pasive-active?

###Security Mechanisms
- Feature designed to detect, prevent, or recover from a security attack
- No single mechanism that will support all services required
- However, one particular element underlies many of the security mechanisms in use:
  - *cryptographic techniques*
   
- Specific security mechanisms:
  - Encryption, Hashing, Message Authentication, Digital Signature, Access Control

= Pervasive Security Mechanisms:
  - Security management, Security audict and evaluation, Incident detection and Response


## Reading Assignment
- Textbook Chapter 1
- FIPS PUB 199
