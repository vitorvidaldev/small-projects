# NGINX

## TLDR

- Web server and HTTP proxy server
- Reverse proxy
- Free and open-source using the BSD license
- Can be deployed to serve dynamic content
- Software load balancer
- Mail proxy
  - TLS/SSL support
  - STARTTTLS support
  - SMTP, POP3, and IMAP proxy
- Upgrading without client connection loss

## Features

Nginx is a web server that can also be used as a reverse proxy, load balancer, mail proxy and HTTP cache. Nginx is a free and open-source software, released under the terms of the 2-clause BSD license. A large fraction of web servers use NGINX, often as a load balancer.

Nginx is really easy to configure in order to serve static web content or to act as a proxy server.

Nginx can be deployed to also serve dynamic content on the network using FastCGI, SCGI handlers for scripts, WSGI application server or Phusion Passenger modules, and it can serve as a software load balancer.

Nginx uses an asynchonous event-driven approach, rather than threads, to handle requests. Nginx's modular event-driven architecture can provide predictable performance under high loads.

Out of the box, serving static files, Nginx uses much less memory than Apache, and can handle roughly four times as many requests per second. However, this performance boost comes at a cost of decresed flexibility, such as the ability to override systemwide access settings on a per-file basis.

### Nginx Unit
Nginx Unit is an open-source web application server,to target multi-language microservices-based applications. The initial release supported applications written in Go, PHP, and Python. By version 1.11.0, the support was extended to Java, Node.js, Perl, and Ruby applications; other features include dynamic configuration, request routing, and load balancing.