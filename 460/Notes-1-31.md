# Notes CS 460
## 1/30/2013

### EXAM 1 NEXT WEEK 

### Recap
- Security Fundamentals
    - Confidentiality/Encryption
    - Integrity
    - Availability
    - Authentication
    - Non-repudiation
    - Trust -> Social Engineering Issues

- Confidentiality
    - Encryption
        - Symmetric
            - Classic Ciphers
            - Modern Cipher: AES
    - Asymmetric
        - Public Key Cryptography: RSA
        - Also Supports Authentication, Non-Repudiation

### Today's Topic 
- Security Fundamentals
    - Confidentiality / Encryption
    - Integrity -> Hash Function & Message Authentication Code
    - Availability
    - Authentication (user) / Digital Signature
    - Non-repudiation / Digital Signature
    - Trust / Social Engineering Issues 

### Hash Functions
- Condenses arbitrary message to fixed size
- `` h = H(M)``
    - Usually assume hash function is public
- Hash used to detect changes to message
    - Also kown as message digest, fingerprint
    
### A Simple Hash Function
- Want to count the occurrences of each Unicode character in a file
- There are 2^16 possible characters, but ...
    - Maybe only 100 or so occur in a given file
- Approach: *hash* character to range 0-199
    - That is, use a hash table of size 200
- A possible *hash function* for this example:
    - ``int hash = uni_char % 200;``
- Collisions are certainly possible
    - Simplest way is linear probing (check the next space)
    - Can also double hash
    - Can have a better hash function 

### Secure Hash Functions
- Computationally infeasible to find data mapping to specific hash (one-way-property)
- Computationally infeasible to find two data to same hash (collision-free property) 

### Message Authentication
- Protect against active attacks 
- Verifies received message is authentic
    - Conents have not been altered
    - From authentic source
    - Timely and in correct sequence
- Can use conventional encryption
    - Only sender & receiver share a key 

> Computational infeasible means assuming current computational powers it's not possible 

> One way property becasue we're not going to decode it 

> Simplest mathematical encryption that can be reversed is XOR 

> We use message length as part of hash function becasue it's more difficult to decipher 

### Message Authentication Codes
- See slides for diagrams
- Message Authentication- Mac / Hash are all different
- Mac is nothing but hash with a key (keyed hash) 

> MIDTERM NOTE: understand slides 10 and 11 
> Be able to draw it 

- The ``||`` symbol is the concatenate symbol 

### Hash Functions & Authentication 
- Message concatenate with hash of message
- Encrypt
- Decrypt, hash again, compare to check authenticity

- We authenticate with hash, encryption is for confidentiality, hash provides integrity as well becasue it's one way and difficult to reverse engineer 

- The 2nd one  the data isn't encrypted but it needs to be authentic
    - Remember the military real-time data question in quiz 1 
    - No reason to hide it, but need to maintain INTEGRITY 
    - Encryption is costly 

- 3rd one is applyin salt before hashing (secret message) 
    - you'll see the world salt, random number, NONCE, IV (initialization vector), just means random input to data to further encrypt 
    
### Hash Functions and Digital Signatures
- Basic difference between this scenario and the last
    - Basic RSA is encrypt message with private key
    - For public key en/decrypt it should be easy for someone to encrypt and decrypt. The public key ``e`` is generally small and the private key is generally large

> WHY do we sign the hash and not the entire message? Because it will take too long otherwise 

- If public key is smaller, private key is larger...so if we use the large key to encrypt the entire message it's very computationally intensive 

> MIDTERM NOTE: Draw a diagram of a data connection where you need...one of the diagrams in the slides 

### Secure Hash Algorithm
- SHA originally designed by NIST & NSA in 1993
- Was revised  in 1995 as SHA-1
- Produces 160-bit hash values 
- Due to security concerns, SHA-512 is recommended 

### SHA Versions
- See slide 13 for table 

### Sha-512 Overview
- add length or message
- pad to 1024 bits
- chop into 1024 blocks, apply encryption and compress to a 512 bit hash unction 

> Understand and be able to draw the diagram  
 
- It's random as hell becasue it's one way, and essentially collision free 

- Each block is affected by previous block (initial affected by IV)  

### Digital Signatures
- Have looked at message authentication
    - But does not address issues of lack of trust
- Digital signatures provide ability to:
    - Verify author, date & time of signature
    - authenticate message contents
    - Be verified by third parties to resolve disputes
        - Non-repudiation

### Direct Digital Signatures
- Invovle only sender & receiver
- Assumed receiver has sender's public key
- Digital signature made by
    - Sender signing entire message or
    - Hash with private-key
- Can encrypt using receiver's public-key

> See slides for Digital Signature Model diagram 

### Digital Signature Standard (DSS)
- US Government approved signature scheme
    - Designed by NIST & NSA in early 90's
    - published as FIPS-186 in 1991
- Uses the SHA hash algorithm
- DSS is the standard, **DSA** is the algorithm
    - FIPS 186-2 (2000) includes alternative RSA & elliptic curve signature variants

- Because RSA's simplicity and wide usage, NIST had to include it 


### DSS vs RSA Signatures

- RSA: encrypt hash, concatenate with message
- DSS: Not only encrypts the hash with private key but also uses symmetric information (shared secret) 

> Understand these diagrams on slide 19 

### Public Key Authority
- Trusted Directory of public keys for distributions 
- Public key authority signs message with private key, sends back to A toprevent interception , then A gets B's public key
- Unfortunatley you also need the public key of the authority 

### Public-Key Certificates
- Certificates allow key echange without real time access to public-key authority
- A certificate binds identity to public key
    - Usually with other info suhc as period of validity, rights of use, etc
- With all contents signed by a truest Public Key or Certificate Authority
- Can be verified by anyion who knows the public-key authorities public-key 

### CA Hierarchy
- if both users share a common CA then they are assumed to know it's public key
- Otherwise CA's must form a hierarchy
- Use certificates linking members of hierarchy to validate other CA's
    - each CA has a certificates for clients (forward) and parent (backward)
- Each client trusts parents certificates
- Enable verification of any certificate from one CA by users of all other CAs in hierarchy 

> X.509 is the current public certificate standard 
> Don't need to know the table for the exam, just the basic information (like the name) 

### Certificate Recovation
- Certificates have a period of validity
- May need to revoke befor eexpiry, e.g:
    1. user's private key is compromised
    2. user is no longer certified by this CA
    3. CA's certificate is compromised
- CA's maintain list of revoked certificates
    - the Certificate Revocation List (CRL)
- Users should check certificates with CA"s CRL 

### Examples
- Bank of American online banking verified by Verisign 
    - This is a widely known 'top level' certificate 
    - Most modern OSs come with this built in 
    
 
