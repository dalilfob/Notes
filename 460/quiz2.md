# CS 460-01 Quiz 2


## Question 1
Encrypt the plaintext: "We shall overcome someday" with the key "sugar" using Vigenere Cipher


```
plaintext:  weshallovercomesomeday
key:        sugarsugarsugarsugarsu
ciphertext: OYYHRDFUVVJWUMVKISEUSS
```

## Question 2

Assume the following is the current state of your AES input. Apply the following transformations: SubBytes, ShiftRows, MixColumns on this state. For SubBytes and ShiftRows show complete output of each transformation. You can refer to the FIPS 197 pub for the S-box and Matrix for the MixColumns


```
19 A0 9A E9
3D F4 C6 F8
E3 E2 8D 48
BE 2B 2A 08
```

1. Using S-box values on page 16 of FIPS 197


```
D4 E0 B8 1E
27 BF B4 41
11 98 5D 52
AE F1 E5 30
```

2. Shift Rows (rows rotated left by array index (0 to n-1))

```
D4 E0 B8 1E
BF B4 41 27
5D 52 11 98
30 AE F1 E5
```

3. Mix Columns

```
[ 02 03 01 01 ][D4 E0 B8 1E] 
[ 01 02 03 01 ][BF B4 41 27]
[ 01 01 02 03 ][5D 52 11 98]
[ 03 01 01 02 ][30 AE F1 E5]
```

```
[0][0] = ({02} * D4) xor ({03} * BF) xor ({01} * {5D}) xor ({01}*30)

= 
```
