# CS 460 Notes
## 3/12/2013

### Denial of Service (DoS)
- Attack on availablity of some service

- Categorizes of resources that could be attacked are:
    - Network Bandwidth
        - Use up all the bandwidth
    - Disruption of configuration information, such as routing information
    - Disruption of state information such as unsolicited resetting of TCP sessions
    - Disruption of physical network components
    - Obstructing the communication media between the intended users and the victim so that they can no longer communicate adequately 

- Attacks may be:
    - On the link (bandwidth)
    - On the device (application (?))
    - On the system itself (system)

### Flooding Attacks

> Security is not just about data, it's very much about money
> Security has DIRE financial implications

- ICMP Flood: 
    - Ping flood using ICMP echo request packets
    - Traditionally network administrators allow such packets in their networks becuase ping is a useful network diagnostic tool 

- UDP Flood
    - Uses UDP packets directed to some port number on the target system

- TCP SYN Flood
    - Sends TCP packets to the target system
    - Total volume of packets is the aim of the attack rather than the system code 

### Flooding Ping Command
- Aim of this attack is to overwhelm the capacity of the network connection to the target organization

- Traffic can be handled by higher capacity links on the path, but packets are discarded as capacity decreases

- Source of the attack is clearly identified unless a spoofed address is used

### Source Address Spoofing
- Use forged source addresses
    - usually via the raw socket interface on operating systems
    - makes attacking systems harder to identify

- Attacker generates large volumes of packets that have the target system as the destination address

- Congestion would result in the router connected to the finall, loewr capacity link

- Requires network engineers to specifically query flow information from their routers

- Backscatter traffic
    
    - Advertise routes to unused IP addresses to monitor attack traffic 

### Sockets and Such
- Why do we even have sockets?
    - Because if you had direct access to the NIC, it'd be stupid
        - Access to the NIC is multiplex
        - Sockets allow each program to decide upon a port, connect, and have the operating system scheduel its connection with the physical network interface 

- A network socket is an endpoint of an inter-process communication flow across a computer network. Most communication between computers is based on the Interner Protocol; therefor most network sockets are INTERNET SOCKETS

- A socket API is an API, usually provided by OS, allows app to control and use network sockets

- A socket address: combination of an IP address and port number, much like one end of telephone connection is combination of phone number + extension

> Unix you can write a raw socket, create packets, and send it
> Ability to create own packets, can also spoof origin

### SYN Flood

- SYN flood occurs when host sends a flood of TCP/SYN packets
    - Often with a forged sender address
    - Each packet handled like connection request casing server to spawn half-open connection by sending back a TCP/SYN-ACK (acknowledgement) packet and waiting for a packet in response from the snder address
    - Because the sender's address is forged, response never comes
    - These connections saturate the number of available connections the server is able to make 

### DDoS Attack Architecture
- Attacker commands zombies via control hierarchy
- Small number of systems act as handlers controller larger number of agent systems
- Send single commands to handler, forwards to agents
- Automated infection tools may be used to can for and compromise suitable zombie systems
- Agent software uplaoded to newly comprised system
- Contact one or more handlers to autmatically notify them of its availability


### Amplification Attacks
- Variant of reflect attack
- nvovles sending packet with spooed source address for target sytem to intermediaries
- Differ in generating multiple response packets for each original packet sent
- Acheived by direct original request ot broadcast address for some network

### DNS Reflect Attack

- Further variation of reflector attack establishes a self-contained loop between the intermediary and the target system

- Both systems act as reflectors

- DNS client sends qury from its UDP port 1792 to server's DNS port 53 to obtain the IP address of the domain

- Send query to DNS server with spoofed IP source address
- Attacker uses port 7 (echo server) as reflector service
- DNS server sends response to the victim of the attack 
- If victim is offering echo service, it may create a packet that echos the received data BACK to the DNS server:
    - Causes loop between DNS server and victim if DNS server reponds to packets

### DoS Attack Prevention
- Block spoofed source addresses
    - on routers as close to source as possible
    - filters may be used to ensure path back to the claimed sourced address is the one being used by the current packet
        - Filters may be applied to traffic before it leaves the ISPs network or at the point of entry to their network

### Responding to DoS Attacks
- Antispoofing, directed broadcast, and rate limiting filters should have been implemented

- Ideally have network monitors and IDS to detect and notifty abnormal traffic patterns

- Good Incident Response Plan
    - details on how to contact technical personal for ISP
    - needed to impose traffic filtering upstream
    - details of how to respond to attack 

- Identify type of attack
    - capture and analyze packets
    - design filters to block attack traffic upstream
    - identify and correct system/application bug

- Have ISP trace packet flow back to source
    - May be difficult and time consuming
    - Necessary if planning legal action

- Implement contigency plan
    - Switch to an alternate backup server
    - Commission new servers at a new site with new addresses

- Update incident response plan
    - Analyze the attack and the response for the future handling

### DDoS Case Sudy: GRC.com

- Gibson Research Corporation
- Provides free internet security testing software: Shields Up, LeakTest, etc
- Attacked in May 2001 by a DDoS attack 
