# CS 460 Notes
## 2/21/2013

### Today's Topic
- Diffe-Hellman Key Exchange
- Secure Socket Layer (SSL)
- Secure Shell (SSH)

### Recap
- Security objectives, mechanism
  - Encryption, Hash, MAC, Dig. Signatures
- Application in Systems security
  - Pass authentication
  - Email security

### Primitive Roots
- From Euler's theorem: ``a^{\phi(n)} = 1(mod\,n)``
- Consider ``a^m = 1 (mod\,n),gcd(a,n)=1``

> See practice question / wikipedia example

### Discrete Logarithms
- The inverse problem to exponentiation is to find the discrete log of number mod n
- Find ``i`` such that ``b = a^i (mod n)``
- Written as ``i = dlog_a b (mod n)``
- Finding a discrete log is hard for big numbers

