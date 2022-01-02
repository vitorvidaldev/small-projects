# Event-driven architecture

Event-driven architecture (EDA) is a software architecture paradigm promoting the production, detection, consumption of, and reaction to events.

An event can be defined as "a significant change in state".

This architectural pattern may be applied by the design and implementation of applications and systems that transmit events among loosely coupled software components and services.

Building systems around an event-driven architecture simplifies horizontal scalability in distributed computing models and makes them more resilient to failure. This is because application state can be copied across multiple parallel snapshots for high-availability. New events can be initiated anywhere, but more importantly propagate across the network of data stores updating each as they arrive. Adding extra nodes becomes trivial as well: you can simply take a copy of the application state, feed it a stream of events and run with it.