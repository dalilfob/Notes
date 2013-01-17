#Notes CS 460
## 1/17/2013

### Recap
- Confidentiality
    - Encryption
        - Symmetric
            - Classic Ciphers
- Modern Cipher: AES

- Substitution:
    - Replacing individual elements with other specific elements
    - If plaintext is represented in binary form, substitution refers to substituting bit patterns 

- Permutation/Transposition:
    - Rearranging elements (change position)
    
- Most classic ciphers used 1 of the techniques (monoalphabetic, polyalphabetic, transposition, etc):
    - Caesar Cipher

### Advanced Encryption Standard
- First widely used modern block cipher is Data Encription Standard (DES)
    - Also twofish, blowfish, triple-DES, etc
- Numerous flas and attacks were discovered 
- NIST called for a new symmetric encryption standard, AES
- Rijndael was selected as the AES in Oct-2000
- Issued as FIPS PUB 197 standard in Nov-2001 

### The AES Cipher - Rijndael
- Designed by Rijmen-Daemon in Belgium
- Has 128/192/256 bit keys, 128 bit data
- Operates on entire data block in every round
- Data block of 4 columns of 4 bytes is state 

```
    PLAINTEXT: ABCDEFGHIJKLMNOP

    A E I M             41 45 49 4D
    B F J N             42 46 4A 4E
    C G K O --(Ascii)-> 43 47 4B 4F
    D H L P             44 48 4C 50
```
> The right side is hex, so each character is 8 bits, 8 by 16 = 128 bit block
> Also why AES is called a 'block' cipher, as opposed to a string cipher that takes either a bit or a byte 

- Once we dump the first 128 bit block inside the matrix we call it the **state** 
### AES Encryption
> See AES ENCRYPTION PROCESS on slides for diagram 

- Round N to round N-1 4 transformations
- Round N-1 to Round N 4 transformations
- Round N to Final state 3 transoformations 

- For key length of 16 bytes (128 bit):
    - 9 initial rounds, 1 final round 

### AES Structure
- Key is expanded to array of words (one column)
- Has 9/11/13 rounds in which state undergoes:
    - byte substitution (1 entry S-box used on every byte)
    - Shift rows (permute bytes between groups/columns)
    - Mix columns (subs using matrix multiply of groups)
    - Add round key (XOR state with key material) 
- Initial XOR key material & incomplete last round 

### Incase you forgot XOR

```
    0 0 = 0
    0 1 = 1
    1 0 = 1
    1 1 = 0 
```
- More than 2 input
    - If you have odd number of 1s it becomes 1 

### AES Structure
> **See Slides for awesome diagram** 
> Under "Lecture 4" Symmetric Encryption 2 

- w(0,3)
    - w = 'word', where each column in the key expansion block is referred to as a word 

### Substitute Bytes
- A simple substitution of each byte
- Use one table of 16x16 bytes containing a permutation of all 256 8-bit values
    - These values are elements of a special Galios Field GF(2^8)
- Each byte of state is replaced by byte indexed by row (left 4-bits) & column (right 4-bits)
    - e.g. byte {41} is replaced by byte in row 4 column 1
    - which has a value of {83}
- Designed to be resistant to all known attacks 

> See page 16 of the FIPS 197 article for a substitution table  

### Shift Rows
- A circular byte shift in each 
    - 1st row is unchanged
    - 2nd row does a 1 byte circular shift to the left 
    - 3rd row does a 2 byte circular shift to the left
    - 4th row does a 4 bytes ...
- Descrypt inverts using shifts to right
- Since state is processed by columns, this step permutes bytes between the columns 

### Matrix Multiplication Refresher
- Row A by Column B 

### Mix Columns
- Each column is processed separately
- Each byte is replaced by a value dependent on all 4 bytes in the column 

### AES Math
- To make sure the results of arithmetic operations don't exceed the data size
    - 0 to 255 in our case
- Galois Field artihmetic uses modulus operation technique to do this 

### GF(2^8) Arithmetic
- Addition is XOR
- Multipliucation by 0x01 remains same
    - {0x01}*{0x46} = 0x46
- Multiplying by 2 is the same as decimal arithmetic, provided the result does not exceed the field size of 255 or 0xFF
- Also multiplying by 2 in binary is the same as shifting left by one 
- If the leftmost bit prior to the shift is 1 the result must by XORed with 0x1B- Multiplying by 3 is the same as multiplying by (1 + 2) thus:

```
  a * 0x03
= a * (0x02 + 0x01)
= (a * 0x02) XOR (a * 0x01) 
```

> See **MIX Columns Example** on slide 21 

- Uses a constant matrix for encryption 
    - The inverse of which is used for decryption 

### Add Round Key
- XOR state with 128-bits of the round key
- Again processed by column (though effectively a series of byte operations)
- Inverse for decryption identical
    - since XOR own inverse, with reversed keys 
