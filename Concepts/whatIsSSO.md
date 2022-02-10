# What is SSO?

SSO means Single sign-on, and it is an important cloud security technology that reduces all user application logins to one login for greater security and convenience. This document is based on [^1] and [^2].

As different applications and resources support different authentication mechanisms, single sign-on must internally store the credentials used for initial authentication and translate them to the credentials required for the different mechanisms.

SSO shares centralized authentication servers that all other applications and systems use for authentication purposes and combines this with techniques to ensure that users do not have to actively enter their credentials more than once.

Instead of establishing their identity over and over, a user establishes their identity once and can then access several different services.

Whenever a user signs in to an SSO service, the service creates an authentication token that remembers that the user is verified. An authentication token is a piece of digital information stored either in the user's browser or within the SSO service's servers, like a temporary ID card issued to the user. Any app the user accesses will check with the SSO service. The SSO service passes the user's authentication token to the app and the user is allowed in. If, however, the user has not yet signed in, they will be prompted to do so through the SSO service.

Benefits:
- Reduce password fatigue from different username and password combinations
- Reduce time spent re-entering passwords for the same identity.
- Mitigate risk for access to 3rd-party sites, with federated authentication, because user passwords are not stored or managed externally
- Simpler administration
- Better administrative control
- Improved user productivity
- Better network security
- Consolidation of hetereogeneous networks

## TLDR
- SSO means Single sign-on
- Is an authentication scheme
- It allows a user to log in with a single ID to any of several related, yet independent, software systems

## References

[^1]: [Wikipedia](https://en.wikipedia.org/wiki/Single_sign-on)
[^2]: [CloudFlare](https://www.cloudflare.com/learning/access-management/what-is-sso/)