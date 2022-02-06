# The Java Language Specification - Notes

06/02/2022

- Language Authors: James Gosling, Bill Joy, Guy Steele, etc.
- Language Version: 17

## Chapter 1 - Introduction

Language characteristics:
- General purpose.
- - What is a general purpose language?
- - What are the advantages and disavantages of general purpose languages?
- - What are the other types of languages?
- Concurrent
- - What is a concurrent language?
- - What is the definitions of concurrent?
- - Does concurrent means parallel? What are the differences?
- Class based
- Object oriented
- - What is a object oriented language? What differentiates then from other languages?
- Intended to be a "production language"
- Strongly typed
- - What does this mean?
- - How does strongly typed languages work?
- - What are the advantages and disavantages of strongly typed languages?
- Statically typed
- - How does static typed languages work?
- - What are the advantages of being statically typed?
- - What are the disavantages of being statically typed?

Compile time: tranlating programs into a machine-independent byte code representation.

Common runtime operations:
- Loading classes
- Linking classes
- Machine code generation
- Dynamic program optimization
- Program execution

Java is high-level language (it favors abstractions over primitives, and machine representation is not available through the language). It has a garbage collector used for automatic storage management. The language does not include any unsafe constructs.
- - What is a garbage collector?
- - How does the Java garbage collector work?
- - What other types of automatic storage management exist?

- What is Unicode?
- What is the Unicode character set?

Primitive types: defined to be the same on all machines and in all implementations. Values of the primitive types do not share state.

Reference types: implemented by dinamically created objects that are either instances of classes or arrays. Classes exist for wrapping primitive values inside of objects.

**All objects support the methods of the class Object, which is the single root of the class hierarchy.**

Variables are typed storage locations. 
- A variable of a primitive type holds a value of that exact primitive type. 
- A variable of a class type can hold a null reference or a reference to an object that is an instance of the named class or any subclass of that class.
- A variable of an interface type can hold a null reference or a reference to an instance of any class that implements the named interface.
- A variable of an array type can hold a null reference or a reference to an array.
- A variable of class Object can hold a null reference or a reference to any object, whether class instance or array.

In Java, declaration order is significant only for local variables, local classes, local interfaces, and the other field initializers in a class or interface.

% section 1.2, page 22