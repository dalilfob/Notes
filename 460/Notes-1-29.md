#CS 460 Notes
## 1/29/2013

### Recap
- Why we need asymmetric?
    - Key distribution in symmetric is difficult

- Public keys maybe distributed without worry
- Problem with symmetric:
    - Sender  needed individual keys for individual receivers 
- Use asymmetric for authentication 

### Public Key Applications
- Encryption/decryption (confidentiality)
- Digital signatures (authentication)
- Key exchange (session keys)

### RSA Public Key Encryption
- Also available are ECC and Jiffy Hellman

### RSA Key Generation

```
Select p,q where p and q are both prime

Calculate n = p x q

Calculate \phi(n) = (p-1)(q-1)

Select Integer e s.t. gcd(\phi(n),e) = 1 and 1 < e < \phi(n)

Calculate d where de mod phi(n) = 1
d is the multiplicative inverse of e 

Public Key:  KU = {e,n}
Private Key: KR = {d,n}
```

- ``Plaintext M -> Ciphertext C`` and M must be smaller than n 

- Encryption `` M^e mod n ``
- Decryption ``C^d mod n`` 


```
ed = 1 mod phi(n) is CONGRUENT TO
ed mod phi(n) = 1

de = 1 + k*phi(n)
de = 1 + k*phi*n) / e
d = 1 + k*160 / 7 
```


```
C = 88 ^ 7 mod 187 = 11 
11 ^ 23 mod 187 = 88 
```

Can also apply modular functions in:


```
8 ^ (4 + 2 + 1) mod 187
= [(88^4 mod 187)(88^2 mod 187)(88 mod 187)] mod 187 
```

This allows to break up really large numbers becuse in reality M and d will be HUGE. 


### Homework and Quiz 2 Returned
- Most people did well on HW2 
- A lot did not mention keys and the ability to access house, cabinet, etc 
- Usually people maintain a single keychain 
- RFID keys come with smart problems
- RFID keys may be copied if technically savvy (read RFID string and copy ) 
- Could have used GPS to see other visited places
- Spear Fishing (coupon for restraunt) 
- This assignment was an ethical grey-zone, it's hard to mediate this knowledge, but it's useful for understanding and countermeasures 
    - Nuclear fission invention probably did not predict the atom bomb 

#### Quiz 2 Review
- Vigenere cipher was fairly straight forward
- 2nd part, mix column had a lot of issues becasue of carelessness

    - Binary transformations were wrong
    
- In exam you will be doing hand calculations and grading will be **HARSH**
- Techniques:
    - write down from 0 to F all the binary to hex 
    
### Office Hours
- Can also setup meeting via email

