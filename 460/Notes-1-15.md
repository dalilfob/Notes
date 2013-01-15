# Notes CS 460
## 1/15/2013

### Recap
- Security Fundamentals
  - Confidentiality->Encryption
  - Integrity
  - Availabilpity
  - Authentication
  - Non-repudiation
  - Trust & Social Engineering Issues 

### Some Basic Terminology
- plaintext: original message
- ciphertext - hidden/coded message
- cipher(encryption): algorithm for transforming plaintext to ciphertext
- encipher(encrypt): converting plaintext to ciphertext
- decipher(decrypt): recovering ciphertext from plaintext
- key: info used in cipher known only to sender/receiver
- cryptography: study of encryption principles/methods 
- cryptoanalysis: breaking key w/o cypher key
- cryptology: The science of secure communications 

### Classification of Encryption
- Based on number of keys
  - sender and receiver user same key-symmetric
    - `1023 == 1023`
  - sender and receiver each use a different key-asymmetric 
    - `1023 <- -> 2046`

### Symmetric Encripytion
- Algorithm is known, key is secret (generally) 

### Techniques Used
- The type of operations used for transforming plaintext to ciphertext
  - Substitution: each element in the plaintext is mapped into another element
    - `L e t ' s g o h o m e` substitute to `M f z ' u ...`
  - Transposition/Permutation: elements in plaintext are rearranged
    - Change relative positions: `f e M '  u`

### Classification
- Classic Ciphers: Based on either permutations or substitution
  - E.x: Caesar cipher, Ralifence cipher
- Modern Ciphers: Combination of substitution and permutation, a product of both
  - Types: Based on how the plaintext input is processed
  - Block Cipher: processes plaintext input one block of elements at a time
     - e.x aes

### Divisors
- Say a non-zero number `b` divides `a` if for some have `a=mb` where a,b,m are all integers
- That is `b` divides into `a` with no remainder
- Denote this as `a | b` 

### Division Algorithm
- If divide a by n get integer quotient q and integer remainder r such that:
  ```
  a = qn + r where 0 <= r < n; q = floor(a/n)
  ```
- remainder r often referred to as a **residue** 

#### Example
(on paper) 

### Modular Arithmetic
- Define **modulo operator** `a mod n` to be remainder `r` when a is divided by n
  - where integer `n` is called the **modulous**
- `r` is called a **residue** of `a mod n` since with integers can always write: `a = qn + r`
  - *smallest* positive remainder as residue
    - `0 <= r <= n-1`

### CLassical Substitution Ciphers
- where letters of plaintext are replaced by other letters or by numbers or symbols
- Or if plaintext is viewed as a sequence of bits, then substitution invovles replacing plaintext bit patterns with ciphertext bit patterns 

### Caesar Cipher
Encryption:
```
E_n(x) = (x + n) % 26
```
Decryption:
```
D_n(x) = (x - n) % 26
```

### Cryptanalysis
- Ideally, recover key not just message
- General approaches:
  - Cryptanalytic attack
    - Relise on the nature of the algorithm plus perhaps some knowledge of the general characteristics of the plaintext or even some sample plaintext-ciphertext pairs.
    - This type of attack exploits the characteristics of the algorithm to attempt to deduce a specific plaintext or to reduce the key being used 
- Bruteforcing

### Cryptanalytic Attacks
- ciphertext only
  - only know algorithm & ciphertext
- known plaintext
  - know/suspect plaintext & ciphertext
- chosen plaintext
  - select plaintext and obtain ciphertext
_ chosen ciphertext
  - seelct ciphertext and obtain plaintext- chosen plaintext
    - select plaintext and obtain ciphertext

### Brute Force Attack
- always possible to simply try every key
- most basic attack, proportional to key size
- assume either know/recognize plaintext 

### Types of Security
- Computational Security
  - given limited computing resources (eg time needed for calculations is greater than age of universe--*god DAMN son*), the cipher cannot be broken
- Unconditional security
  - regardless of time/resources cipher canno tbe broken 
    - THIS IS AWESOME...but is there a practical way to do this? 

### Cryptanalysis of Caesar Cipher
- Only have 26 possible ciphers
- Could simply try each in turn
- A brute force search
- Given ciphertext, just try all shifts of letters
- Do need to recognize when have plaintext

### Monoalphabetic Cipher Security
- Rather than shifting the alphabet
- Could shuffle ...
- 26! number of keys

###Example Cryptanalyiss
- Given some cipher text
- Count relative letter frequencies
- Guess P & Z are e and t
- guess ZW is th and hence ZWP is the
- Proceed with trial and error 

### Vigenere Cipher
- polyalphabetic cipher

### Vigenere Table 
- Has shifts for each alphabet 

####Cryptanalysis of Vignere Cipher
- If you know the length of the key 
  - Chop into columns , then apply frequency analysis 

