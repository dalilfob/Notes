# CS  460 Notes
## 2/14/2013

### Midterms Returned
90-100 4
80-89 17
70-79 7

- gcd(phi(n),e) = 1
- Requires prime numbers p and q
- MAC is hash with a key
- Hash is used for checking integrity
- phi(n) = n-1 , n prime 

### Recap
- Cofidentiality
    - Symmetric: AES
    - Asymmetric: RSA
- Integrity
    - Hash: SHA256
- Authentication
    - Message Auth: MAC
    - User Authentication: Digital Signature
- Non-repudiation
    - Digital Signature
    - Certificates
- Trust
- Systems Security
    - JCE (Java crypto)
    - OpenSSL (AES/RSA/DS/Hash/Mac)

- Individual Components of System Security
    - Password Authentication
    - Email Security
    - Software Security
    - OS Security
    - Network Security 

- Certificate
    - Public Key + Identity Information 
- Certificate Authority
    - Trusted authority that verifies a certificate 
    - Identity of certificate 'bound' by authority

### Password Authentication & Email Security
- Widely used line of defense against intruders
    - Users provides name/login and password
    - System compares password with the one stored for that specific login
    - The user ID:
        - determins that the user is authorized to access the  system
        - determines level of privelage 

### Password Vulnerability
- Offline dictionary attack
- Password guessing against single user
- Workstation Hijacking
- Electornic Monitoring

### Password Cracking
- Dictionary Attacks
    - Develop a large dictionary of possible passwrods and try each against the password file
    - Each password must be hasehd using each salt value and then compare to stored hash values
- Rainbow Table attacks
    - Precompute tables of hash values for all salts     

### Email Security
- Email is one of the most widely used regarded networks
...


### PGP , Pretty Good Privacy
- Widely used defacto secure email
- Developed by Phil Zimmermann
- Selected best available crypto algo 
