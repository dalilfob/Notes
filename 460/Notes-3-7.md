# CS 460 Notes
## 3/7/2013

## Network Security

### Course Map
- Basic Cryptography
    - Security objectives, mechanisms and specific algorithms

- Systems security

- Hash/Encrypt diagrams again, which provides confidentiality via encryption and authentication via encryption

- If you just use hash concatenated with a message, it provides nothing...

- Figure (b) provides message authentication, because only the hash is being encrypted 

- Message authentication we use a semetric key on top of the hash, whereas in hash we do not

- Salt, random number, etc are nothing but shared secrets 
    - Some algorithms call them shared secret key

### IP Network
- What kind of packets do Routers handle:
    - IP Packets

- At Transport Layer: TCP packets
- At Data Link Layer: Frames
- At Physical Layer: Bits 


### IP Packet
- TCP Payload

### Transport and Tunnel Mode
- TCP payload (TCP header & User Data), requires confidentiality and authentication (?) 
- If TCP payload not encrypted, anyone on route to the destination may intercept and change the content

- Motivation for IPSEC: provide confidentiality and authentication for the TCP Payload 

- Do you need IPSEC if you use S/MIME?
    - Rule of thumb if lower layer is not secure, encrypt your data. User has control at application level, not really at network level. SO ...stick with SMIME/PGP for it's in your control 
    - For each system however, there is thread analysis for the network
        - There are scnearios where the network layer provides attack vectors, and you may need a combination of IPSEC and SMIME (other application level encryption) 

- If you use SMIME you're guarented confidentiality of your data, however, network level may be susceptible to integrity of it (just mess up the data) 

- Why between the two transports we don't need to encrypt the header?
    - ...

- Tunnel Mode
    - Router encrypts original complete IP Packet including the IP Header, then apply a new IP header 
    - 

### Encapsulating Security Payload (ESP)
- Security Parameteris Index (SPI)
- Sequence Number
- Payload Data (variables) 

- Mails are not sent in one IP Packet, they may be sectioned based on max packet size 

- Why do we need to pad? 
    - block ciphers & size homie



### IPSec Key Management
- Modified version of Diffe-Helman
- Handle's key generation and distribution
...

### Back to the OSI Model

- Decide what you need based on the exact structure of your network 

```
user1 ------|         |---------user3
            R1--------R2
user2 ------|         |---------user4
```

- Assume:
    - IPSec tunnel mode between R1 and R2
    - User 4 is a webserver
    - Between User1 and R1, uses SSL
    - Between User2 and User3 uses simple HTTP
        - For sending email
        - Uses S/MIME
    - User1 and User3 comminicates via email:
        - WITHOUT S/MIME

- Have user5 on the right hand network, running wireshark
    - on both wireless / wired

- Can this malicious USER5 see message content between user2 and user3 ? 
    - No, S/MIME 

- User5 can not see much at all, because of SSL and S/MIME 

> MEMORIZE THIS DIAGRAM

- If you use IPSEC is your data still protected?
    - Yes, because the payload and header are encrypted 


### Homework 5
- Read everything before starting
    - Section 3 , read it homie

- Task2/3/4 are just one command line instruction to test whether it works 


- THE ADDRESS IS READ BACKWARDS
