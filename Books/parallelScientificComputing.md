# Parallel Scientific Computing in C++ and MPI

To solve realistic problems we need not only fast algorithms but also a combination of good tools and fast computers.

- Algorithms
- Tools
- Computers

## Chapter 1 - Scientific Computing and Simulation Science

### What is Simulation?

The simulation approach has already been followed by the majority of researchers across disciplines in the last few decades. The question is if this is a new science, and how one could formally obtain such skills. Moreover, does this constitute fundamental new knowledge or is it a "mechanical procedure", an ordinary skill that a chemist, a biologist or an engineer will acquire easily as part of "training on the job" without specific formal education. It seems that the time has arrived where we need to reconsider boudaries between disciplines and reformultate the education of the future simulation scientist, an inter-disciplinary scientist.

In classical science we are daling with matter and therefore atoms but in simulation we are dealing with information and therefore bits, so it is atoms versus bits! We should, therefore, recognize the simulation scientist as a separate scientist, the same way we recognized just a few decades ago the computer scientist as different than the electrical engineer or the applied methematician. The new scientist is certainly not a computer scientist although she should be computer literate in both software and hardware. She is not a physicist although she needs a sound physics background. She is not an applied mathematician although she needs expertise of mathematical analysis and approximation theory.

## A Seamless Approach Path

```mermaid
graph TB;
Algorithms-->This Book;
C++-->This Book;
MPI-->This Book;
```

In the scientific simulation approach there are several successive stages that lead from:
1. The real world problem to its mathematical formulation;
2. From the mathematical formulation description to the computer implementation and solution, and
3. From the numerical solution to visualization and analysis.

In this book, we concentrate on stage 2 which includes not only the mathematics of numerical linear algebra and discretization but also the implementation of these concepts in C++ and MPI.

Page 13
