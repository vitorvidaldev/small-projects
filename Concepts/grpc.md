# gRPC

gRPC (Google Remote Procedure Call) is an open source remote procedure call (RPC) system initially developed as the next generation of the RPC infrastructure. It uses HTTP/2 for transport, Protocol Buffers as the interface descripton language, and provides features such as authentication, bidirectional streaming and flow control, blocking or nonblocking bindings, and cancellation and timeouts. It generates cross-platform client and server bindings for many languages. Most common usage scenarios include connecting services in a microservices style architecture, or connecting mobile device clients to backend services.

gRPC is a CNCF incubation project.

## Authentication

gRPC supports the usage of TLS and token-based authentication.

## Encoding

gRPC uses Protocol Buffers to encode data. Contrary to HTTP APIs with JSON, they have a mosre strict specification. Due to having a single specification, gRPC eliminates debate and saves developer time because gRPC is consistent across platforms and implementations.

## References

[^1][Wikipedia](https://en.wikipedia.org/wiki/GRPC)
[^2][Official site](https://grpc.io/)