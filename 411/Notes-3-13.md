# CS 411 Notes
## 3/13/2013

## Final: MONDAY 1:40 to 3:40
- Comprehensive
- SLR, LLRK
- Be able to convert 2d to 3d (Symbol, goto, etc)

### SDD For a Declaration Statement

- Given Sentence: ``int id1, id2, id3;``
```
productions     Semantic Rules
-----------     --------------
D -> T L ;      L.in = T.type
T -> int        T.type = int
T -> double     T.type = double
L -> L,id       L.in = L.in; addtype(id.entry)
L -> id         L.dummy = addtype(id.entry, L.in)

```
### Symbol Table

```
name    type    value  scope/level
----    ----    -----  -----------
id1
id2
.
.
.

```


- Unordered list: retrival O(n), insert O(1)
- Ordered list: retrival O(logn), insert O(n)

> We use Trie or HashTable

Modified:

```
Switch: [ ][ ][ ][ ]

Symbol: $  $  $  @  0  $  $  $  @  0  ...
Next  :                            2
```

#### Example Source

```
static int w;
int x;
void example(int a, int b)
{
    int c;
    {
        int b,z;
        ...
    }
    {
        int a,x;
        ...
    }
    {
        int c, x;
        b = a + b + c + w;
    }
}
```

Level/Scope Table:

```
level
-----
0        x,w,example
2a       b,z  
2b       a,x
3        c,x
```

> See notes for annotated tree

### S-attributed Definition:
- An SDD with only synthesized attributes 

- attributed can be evaluted from bottom up 

How?: Use another stack called "val stack"

Paralell stacks: (with same 'top')

``` 
|   |  |   |
|   |  |   |
|   |  |   |
|   |  |   |  
|   |  |   |
-----  -----
state  val
stack  stack
```

```
L -> E eoln
E -> E + T | T
T -> T * F | F
F -> (E) | num
```

Given string: ``3 * 5 + 4 eoln``

Drivation Tree:

```
        L
       / \
      E   eoln
     /|\
    E + T
    |    \
    T     F
   /|\     \
  T * F     num(4)
  |   |
  F   num(5)
  |
  num(3)
```

SDD:

```
production      code
----------      ----
L -> E eoln     print(val[top-1])
E -> E1 + T     val[ntop] = val[top2] + val[top]
E -> T          no action
T -> T1 * F     val[ntop] = val[top-2] * val[top]
T -> F          -
F -> (E)        val[ntop] = val[top-1]
F -> num        -
```

## Final (From this section)

> SHOULD be able to generate an annotated parse tree given an SDD
> Write an SDD from a grammar 
