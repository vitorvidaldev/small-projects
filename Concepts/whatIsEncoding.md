# What is Enconding?

Character enconding is the process of assigning numbers to graphical characters, allowing them to be stored, transmitted, and transformed using digital computers. The low cost of digital representation of data in modern computer systems allows more elaborate character codes which represent most of the characters used in many written languages. Character encoding using internationally accepted standards permits worldwide interchange of text in electronic form.

In computers, encoding is the process of putting a sequence of characters into a specialized format for efficient transmission or storage. Decoding is the opposite process -- the conversion of an encoded format back into the original sequence of characters.

UTF-8 is a variable-width character encoding used for electronic communication.

## Terminology

- A character is a minimal unit of text that has semantic value;
- A character set is a collection of characters that might be used by multiple languages;
- A coded character set is a character set in which each character corresponds to a unique number;
- A code point of a coded character set is any allowed value in the character set or code space;
- A code space is a range of integers whose value are code points;
- A code unit is a bit sequence used to encode each character of a repertoire within a given encoding form.

The character repertoire is an abstract set of more than one million characters found in a wide variety of scripts including Latin, Cyrillic, Chinese, Korean, Japanese, Hebrew, and Aramaic.

The code unit size is equivalent to the bit measurement for the particular encoding:
- A code unit in US-ASCII consists of 7 bits;
- A code unit in UTF-8, EBCDIC and GB18030 consists of 8 bits;
- A code unit in UTF-16 consists of 16 bits;
- A code unit in UTF-32 consists of 32 bits.

A code point is represented by a sequence of code units. The mapping is defined by the encoding. Thus, the number of code units required to represent a code point depends on the encoding:
- UTF-8: code points map to a sequence of one, two, three or four code units.

## References
[^1] [Wikipedia](https://en.wikipedia.org/wiki/Character_encoding)