# Resource acquisition is initialization

Resource acquisition is initialization (RAII) is a programming idiom used in several object-oriented, statically-typed programming languages to describe a particular language behavior. In RAII, holding a resource is a class invariant, and is tied to object lifetime. Resource allocation is done during object creation, by the constructor, while resource deallocation is done during object destruction, by the destructor. In other words, resource acquisition must suceed for initialization to succeed. Thus if there are no object leaks, there are no resource leaks.

C++ guarantees that all stack objects are destroyed at the end of the enclosing scope, known as stack unwinding. The destructors of both the lock and file objects are therefore guaranteed to be called when returning from the function, whether an exception has been thrown or not.

The advantages of RAII as a resource management technique are that it provides encapsulation, exception safety, and locality.

RAII only works for resources acquired and released by stack-allocated objects, where there is a well-defined static object lifetime. Heap-allocated objects which themselves acquire and release resources are common in many languages, including C++.