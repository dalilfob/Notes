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


    Do not trust any attachments unless you are absoloutely aware of the contents

#### Example of Spear Phishing 2
- Linkedin invite by Bill Gates 
  - Fake login page

###Social Engineering from an Online Social Networking Perspective
- An exploitation of **trust**
  - A social network is a platform built on trust

- *Huge* attack surface
- Quick and easy, even automated
  - e.g. botnet to gater email address for phishing
- Low barrier entry point (skills not necessarily required)
- Often relies on publicly available information 

- Trust model
  - No real authentication
  - Easy to impersonate someone else or set up profile
- Influential
  - ... 
  - Based on 'like' mechanism of Facebook & Google+

### Impersonation in the Real World
- Takes money (to buy police costumes)
- May invovle other criminal activities ("procuring" police costumes, impersonation public offical, physically harming victims)
- Takes a lot of planning

### The Robin Sage Experiment
- 28 day experiemnt run by Provide Security
- Security researchers created a fake Facebook, Twitter and Linkedin profile under the alias Robin Sage
- They use da photo of an attractive girl from an adult website
- They have her the job title "Cyber Threat Analyist"
- Established relations with more than 500 companies (global agencies, DOD, Fortune 500, etc)
- Got connected from 300 security officials, gathered leaked information from online

### Discrepancies
- 10 years of cyber security expereience at 25 years of age
- Robin Sage is the name of a military exercise
  - AND 
- OBVIOUSLY did not know this person ... still they allowed connections 


    Keep this experiment in mind; why connect with people you do not know

###Terremark: Company Picnic, 2009
- An emplyoee, Bob, posted on his facebook profile that he would be attending a company picnic
- Attackers hijacked Bob's Facebook account and sent out a message after the picnic that read:
   - Hey Alice, look at the pics I took of us last weekend at the picnic. Bob
   - Alice clicked on the accompanying link, installed a key-logger
   - The attacker used Alice's company logon to access the company network for two weeks gaining control over 2 servers   


### Koobface Virus
- Users receive a message on their Facebook inbox:
  - You look funny in this new video
  - Look, you were filmed!
  - Yo look just awesome in this movie
- User clicks on (malicious) URL to view 
  - Requires fake update of flash-player **LOOKS AUTHENTIC** 

###Reconnaissance
- Personal information (phone, dob, address, etc)
  - often publicly available (directly or indirectly)
  - your friends post a message wishing you a happy birthday 
- Answers to secret quetions
- Company profile, etc...

*Note*: Randy Zuckerberg scandal

- Inferrance of data (discover DOB by high school graduation date) 


    This information can eaisly craft a Spear Phishing attack

### Alarmingly
- Most of the time people spend on scoail networking sites is during office hours 

### Reverse Social Engineering
- An alternate approach to social engineering is called reverse social engineering
- Here, the attacker hopes to convince the target to initiate the contact
  - The attacker may be succesful because the target initiates contact 

- Methods of convincing the target to make the initial contact include:
  - Sending out a spoofed e-mail claiming to be from a reputable source that provides another e-mail/contact info
  - Posting a notice or creating a bogus Welcome message
  - Renting 800 numbers as eaisly as $10/hr

### Combating Social Engineers
- User Education and Training
- Identifying Ares of Risk
  - Tactics correspond to Area
- Strong, Enforced, and Tested Security Policy 

```
    Clean your online presence (search your name on google) 
```

###No Free Lunch
- Type netstat cmd prompt when going to say a movie pirating site
  - 20/25 connections may be open 
