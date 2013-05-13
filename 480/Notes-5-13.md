# CS 480 Notes
# 5/13/2013

## Design Patterns

### Document Editor Example
- Uses Glpyhs for characters
- Suggestion:
    - Use hashmap of glyphs incase of similarities
    - Use WeakHashMap


#### Flyweight (Glyph)
- Declares an interface through which flyweights can receive an act on extrinsic states
- Information Hiding:
    - Document does not know of the hashmap
- Similar to factory pattern
- Similar to FreeList in C++
- Same way Strings and Integers are done in Java
    - Called "interning"
- Not really about flexibility and reuse
- More about memory performance

#### Flyweight Example
```
if(flyweight[key] exists) {
    return existing flyweight;
}
else {
    create new flyweight;
    add it to a pool of flyweights;
    return new flyweight;
}

```

#### What kind of diagram would help analyzing this space problem?
- Object Diagram

### Paint/Canvas/Tool Example
- Add undo method 

#### Memento Pattern


### File System Example

#### Coding Exercise

```
public void Lister(File file) {

    System.out.println(file.getName());

    if (file instanceof Directory) {
        Directory dir = (Directory)file;
        for (file c: dir.getFiles()) {
            Lister(c);
        }
    }
}
```

#### Composite Pattern
- Adding ``getFiles()`` to File, returns list, this way no need to check instanceof
- You want to represent part-whole hierarchies of objects
- You want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly. 

- Flexibility
    - Can add any type of file that contains files
- Reuse
    - 1 algorithm to print
