# CS 460 Notes
## 1/24/2012

### Recap

- Confidentiality
    - Encryption
        - Symmetric
            - Classic Ciphers
            - Modern Cipher: AES
        - Asymmetric
            - Public Key Cryptography: RSA
            - Also supports Authentication, Non-Repudiation

- AES has 128/196/256 bit data 

### Block Cipher Modes of Operations
- Block ciphers encrypt fixed size blocks
- Need practical ways to encrypt arbitrary amount of data

### Electronic Codebook (ECB)
- Message is broken into independent blocks which are encrypted 
- Each block is a value which is substituted, like a codebook, hence the name
- Each block is encoded independently of the other blocks


```
C_i = AES_{k1}(P_i)
```

- Usage: secure transmission of single values

### Advantages and Limitations of ECB
- Repetitions in message may show in ciphertext
    - particularly with data such as graphics
    - or with messages that change very little
- Weakness due to encrypted message blocks being independent
- Main use is sending few blocks of data


### Cipher Block Chaining (CBC)
- Message is broken in to blocks
    - Linked together in encryption operation
- Each previous cipher block is chained with current plaintext block
- Use Initialization Vector (IV) to start process


```
C_i = AES_{ki}(Pi XOR C_{i-1})
C_-1 = IV
```

- Usage: bulk data encryption, authentication

### Advantages and Limitations of CBC
- Each ciphertext block depends on all message blocks 
    - A change in the message affects all ciphertext blocks after the change as well as the original block
- Need Initialization Vector (IV) known to sender & receiver
    - However, if IV is sent in the clear, and attacker can change bits of the first block, and change IV to cmpensate
    - Hence, either IV must be a fixed value or it must be sent encrypted in ECB mode before rest of message 

### Padding Scheme
- At end of message, handle possible last SHORT block
    - Padd with known non-data value (e.g. nulls) 
    - pad with last block with count of pad size (repeat) 

### Public-Key Cryptography
- Probably the most significatn advance in the 3000 year history of crypto
- Asymmetic since parties are not equal
- Uses clever application of number theory concepts to function
- complements rather than replaces private key crypto

### Why Public-Key Cryptography
- Developed to address two key issues:
    - key distribution-how to have secure communications in general without having to trust a KDC with your key
    - Digital Signatures- how to verify a message comes intact from the claimed sender
- Public invention due to Whitfield DIffe & Martin Hellman at Stanford (1976) 
    - known earlier in classified community 

### Public-Key Cryptography (it's Asymmetric)
- Public-key/two-key/asymmetric cryptography invovles the use of two keys:
    - A public-key, which may be known by anybody, can be used to encrypt messages, and verify signatures
    - A related private-key, known only to the recepient, used to decrypt messages, and sign (create) signatures
- Is asymmetric because:
    - those who encrypt or verify cannot decrypt or create signatures

### Public-Key Applications
- 3 categories:
    1. encryption/decryption (provide confidentiality)
    2. Digital signatures (provide authentication)
        - use private key to encrypt, public to decrypt 
    3. Key exchange (of session keys) 

### Diagrams Page: 55

### Requirements for PKC systems
- Computationally easy to create key pairs
- Computationally easy for sender knowing public key to encrypt messages
- Computationally easy for receiver knowing private key to descrypt ciphertext
- Computationally infeasible for opponent to determine private key from public key
- Computationally infeasible for oponnent to otherwise recover original message
- Useful if either key can be used for each role

### Computational Security vs Unconditional Security
- Computational security: formual too hard
- Unconditiional: unable to decipher if plaintext is for reals 

### Security of Public Key Schemes
- Like private key schemes brute force exhaustive search attack is always theoretically possible
    - but keys used are too large (> 512 bits)
- Security relies on a large enough difference in difficulty between easy (en/decrypt) and hard (cryptanalyze) problems
- More generally the hard problem is known , but is made hard enough to be impractical to break
- Requires the use of very large numbers
- Hence is slow compared to private key schemes 

### RSA Public-Key Encryption
- By Rivest, Shamir, and Adleman of MIT 1977
- Best known Publick-Key algo
- Uses: Integer exponentiation modulo a prime 
- Public-key encryption algorithm with
    - page 57 

### Prime Factorisation
- To factor a number n is to write it as a product of other numbers: ``n = a*b*c``
- Factoring is hard
- Prime factorisation is even harder:
    - Write as a product of primes...

### Relatively Prime Numbers & GCD
- Two numbers: ``a`` and ``b`` are relatively prime if they have no common divisions apart from 1

#### Example


```
8 & 15 are relatively prime since factors of 8 are 1,2,4,8 and of 15 are 1,3,5,15 and 1 is the only common factor 
```

### Fermat's Theorem
- ``a^{p-1} = 1(mod p)
    - where p is prime and gcd(a,p) = 1
- also known as Fermat's Little Theorem 
- also have ``a ^p = a(mod p)``  


### Euler Totient Function \phi(n) 
- When doing arithmetic modulo n
- complete sets of residues is: 0 to n-1
- Reduced set of residues are those numbers (residues) which are relatively prime to n
    - e.g. for n = 10
    - complete set of residues is {0,1,2,3,4,5,6,7,8,9}
    - reduced set of residues is {1,3,7,9}
- Number of elements is reduced set of residues is called the Euler Totient Function \phi(n) 

#### EXAMPLE
- phi of 10 is 4 ( mod 10 is 0 through 9, 4 of those are gcd(n,10) = 1 with 10) 
- phi of 5 is 4 (1,2,3,4 are all gcd = 1 with 5)
- phi of 3 is 2 (1,2) 

### Euler's Theorem
- a generalization of Fermat's Theorem
- ``a^{phi(n)}`` = 1(mod n) 

### RSA Key Generation
- Select p and q
- calculate ``n = p * q``
- select e so that ``gcd(phi(n), e)`` and ``1 < e < phi(n)``
- calculate d so that ``d * e mod phi(n) = 1``
- Public key = ``KU = {e,n}``
- Private key = ``KR = {d,n}``

- d,e are multiplicative inverses of each other 


