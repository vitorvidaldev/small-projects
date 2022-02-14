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

A preview feature is:
- A new feature of the Java programming language (preview language feature);
- A new module, package, class, interface, field, method, constructor, or enum constant in the java.* or javax.* namespace (preview API) that is fully specified, fully implemented, yet implemented.

Java SE 17 defines one preview language feature: Pattern Matching for switch.

## Chapter 2 - Grammars

This chapter describes the context-free grammars used in the specification to define the lexical and syntatic structure of a program.

### Context-free grammars

A context-free grammar consists of a number of productions. Each production has an abstract symbol called a nonterminal as its left-hand side, and a sequence of one or more nonterminal and terminal symbols as its right-hand side. For each grammar, the terminal symbols are drawn from a specified alphabet.

## Chapter 3 - Lexical Structure

Programs are written in Unicode, but lexical translations are provided so that Unicode escapes can be used to include any Unicode character using only ASCII characters. Line terminators are defined to support the different conventions of existing host systems while maintaining consistent line numbers.

## Unicode

Programs are written using the Unicode character set.

The Java programming language represents text in sequences of 16-bit code units, using UTF-16 encoding.

Except for comments, identifiers, and the contents of character literals, string literals, and text blocks, all input elements in a program are formed only from ASCII characters.

ASCII is the American Standard Code for Information Interchange. The first 128 characters of the Unicode UTF-16 encoding are the ASCII characters.

## Lexical Translations

% page 34