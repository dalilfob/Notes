#Notes CS 460
## 1/10/2013

###Recap
- Security fundamentals
  - Confidentiality
  - Integrity
  - Availability
  - Authenticity
  - Non-repudiation
  - Trust 

    If Trust is violated, there is no point to any other safetyguards

###What is Social Engineering?
- Uses psychological methods
- Exploits human tendency to trust
- Goal is mining information of interest

###Why Social Engineering?
- Eaiser than technical hacking
- Hard to detect and track
  - 496-bit RSA Encryption
  - see XKCD comic about 'crypto nerd'
- *Note* See "Facebook SOcial Engineering Attack Strikes NATO"

###THe Mind of a Social Engineer
- More like actors than hackers
  - Learn to know how people feel by observing their actions
  ...

###Attack Vectors
Attack Vector
: Pathway an attacker can take to impersonate someone

- In person/Physical
- On-line as e-mail & social network

###Psychology of Approaches
- Carelessness
- Comfort Zone
- Helpfulness
- Fear

###Carless Approach
- Victim is careless
  - Does not implement, use, or enforce proper countermeasures
- Used for reconnaissance
- Looking for whay is laying around
- Dumpster Diving
  - Huge amount of information in the trash
  - Most of it does not seem to be a threat
  - The who, what and where of an organization
  - Knowledge of internal systems
  - Materials for greater authenticity
  - Intelligene agencies have done this for years 

###Comfort Zone Approach
- Victim organization memebrs are in a comfortable environment
   - Lower threat perception
- Usually requires the use of another approach

    "I'm behind closed doors, I'm fine right?"

- Impersonation
  - Could be anyone
    - Tech support
    - Co-worker
    - Boss
    - CEO
    - User
    - Maintainance Staff

###Comfort Examples (cont..)
- Shoulder Surfing
  - Might use a hidden camera
- Direct Theft
  - Outside workplace
  - Wallet id badge, or purse stolen
- Smoking Zone
  - Well known attack where social engineer smokes with victim, then walks inside with him

- Insider Threats
  - Legitimate employee
  - Could sell or use data found by "accident"
  - Result of poor access control
  - Asking for favors from IT staff for information
     - Usually ...
###Helpful Approach
- People generally try to help even if they do not know who they are helping
- Usually ..

- Piggybacking
  - Attacker will trail an employee entering the building
  - More Effective:
    - Carry something large so they hold the door open for you
    - Go in as a group...

- Troubled user
  - Calling organization numbers asking for help
  - Getting a username and asking to have a password reset

### Fear Approach
- Usually draws form the other approaches
- Puts the user in a state of (? fear) ...

- Conformity
  - The user is the only one who has not helped out the attacker with this request in the past
  - Personal responsibility is diffused

- Time Frame
  - Fictitious deadline
  - Password change

- Importance
  - Classic boss or director needs a routine password reset
  - Showing up form a utility after a natural occurence (thunderstorm, tornado, etc)
  - Regulation compliance

###Online Attack Vectors
- Spear-Phishing
- Online Social Netowrks 
  - Reverse Social Engineering


###Phishing
- Phishing is a type of deception designed to steal your valuable personal data, such as credit card numbers, passwords, account data, or other information

- Con artists might send millions of fraudulent e-mail messages that appear to come from Web Sites like your bank or credit card company, and request that you provide personal information 

### Spear-Phishing: Improved Target Selection
- Socially aware attacks
- Context Aware Attacks

1. Socially aware attacks
  - Mine social relationships from public data
  - Phishing email appears to arrive from someone
  - Use spoofed identity of trusted organization ot gain trust
  - Urge victims to update or validate their information

2. Context aware attacks
   - Gets some informationa bout you (bidding for something on ebay)
   - Aware of what you are doing and exploit it 
   - Find information via social networks  -- information you voluntarily give
   - DOD started training of their employees to protect against Spear-Phising

#### Example of Spear Phishing
- DOD emplyoee received what looked like a legitimate subopena (via spoofing email)
  - Never trust email addresses unless validated (later on in the course) 
- Anxiety / fear approach
- The subopena spoof was sent with an infected PDF file 
