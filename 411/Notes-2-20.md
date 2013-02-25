# CS 411 Notes
## 2/20/2013

### More Bottom-Up Parsing!

```
(0) S' -> S
(1) S  -> SaSb
(2) S  -> eps

A_0 = V1(eps) // where V stands for viable prefix 
              // and eps is the initial stack contents
              // subscript = # of lookahead

```

### Some copy and paste magic...

```
A0 = V1(ε)

    I:  [S' –> .S, ε]  //things to the right of the dot 

    //need to be processed   

    //ε is the local follow set of S' 

    //S is after dot: 2 S-productions 

    //create 2 more entries (see the 

    //rule below to add items) 

      [S –> .SaSb, ε] 

        [S –> . , ε] 

             //S is after dot: 2 more entries 

          [S –> .SaSb, a] 

            [S –> . , a] 

                 //Since we have sets that are the 

                 //same, but with different follow 

                 //sets, we combine them: 
```

### Rules to add new items to a table 

Ai: If ``[A->.Ba, u]`` is in ``Vk(y)`` the item ``[B-> .Q, x].


### Rules to check for consistency


