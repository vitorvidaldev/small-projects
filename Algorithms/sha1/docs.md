# SHA-1

In cryptography, SHA-1 (Secure Hash Algorithm 1) is a cryptographic hash function which takes an input and produces a 160-bit (20-byte) hash value known as a message digest - typically rendered as a hexadecimal number, 4o digits long. It was designed by the United States National Security Agency, and is a U.S. Federal Information Processing Standard.

SHA-1 hashes are frequently used to compute short for binary or text blobs. For example, the git revision control system uses SHA-1s extensively to identify versioned files and directories.

## Golang

Package sha1 implements the SHA-1 hash algorithm defined in RFC 3174.

SHA-1 is cryptographically broken and should not be used for secure applications.

The pattern for generating a hash is `sha1.New()`, `sha1.Write(bytes)`, then `sha1.Sum([]byte{})`.

`Write` expects bytes. If you have a string `s`, use `[]byte(s)` to coerce it to bytes.

`Sum` gets the finalized hash result as a byte slice. The argument to `Sum` can be used to append to an existing byte slice: it usually isn't needed.

SHA-1 values are often printed in hex, for example in git commits. Use the `%x` format verb to convert a hash results to a hex string.