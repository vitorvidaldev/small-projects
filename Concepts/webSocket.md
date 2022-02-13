# WebSocket

WebSocket is a computer communications protocol, providing full-duplex communication channels over a single TCP connection.

WebSocket is distinct from HTTP. BOth protocols are located at layer 7 in the OSI model and depend on TCP at layer 4.

The WebSocket protocol enables interaction between a web browser (or other client application) and a web server with lower overhead than half-duplex alternatives such as HTTP polling, facilitating real-time data transfer from and to the server. This is made prossible by providing a standardized way for the server to send content to the client without being first requested by the client, and allowing messages to be passed back and forth while keeping the connection open.

## Security considerations

Unlike regular cross-domain HTTP request, WebSocket requests are not restricted by the same-origin policy. Therefore, WebSocket servers must validate the "Origin" header against the expected origins during connection establishment, to avoid cross-site WebSocket hijacking attacks (similar to cross-site request forgery), which might be possible when the connection is authenticated with cookies or HTTP authentication. It is better to use tokens or similar protection mechanisms to authenticate the WebSocket connection when sensitive (private) data is being transferred over the WebSocket. A live example of vulnerability was seen in 2020 in the for of Cable Haunt.

## Glossary

- Full-duplex: A full-duplex (FDX) system allows communication in both directions, and, unlike half-duplex, allows this to happen simultaneously.
- Communications protocol: A communication protocol is a system of rules that allows two or more entities of a communications system to transmit information via any kind of variation of a physical quantity. The protocol defines the rules, syntax, semantics and synchronization of communication and possible error recovery methods. Protocols may be implemented by hardware, software, or a combination of both.
- TCP: The Transmission Control Protocol (TCP) is one of the main protocols of the Internet protocols suite. TCP provides reliable, ordered, and error-checked delivery of a stream of octets (bytes) between applications running on hosts communicating via an IP network.
- OSI model: The Open Systems Interconnection model (OSI model) is a conceptual model that characterises and standardises the communication functions of a telecommunication or computing system without regard to its underlying internal structure and technology. Its goal is the interoperability of diverse communication systems with standard communication protocols.
- HTTP: The Hypertext Transfer Protocol (HTTP) is an application layer protocol in the internet protocol suite model for districuted, collaborative, hypermedia information systems.

## References

[^1][Wikipedia](https://en.wikipedia.org/wiki/WebSocket)