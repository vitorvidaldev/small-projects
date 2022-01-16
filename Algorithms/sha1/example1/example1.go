package main

import (
	"crypto/sha1"
	"fmt"
	"io"
	"log"
)

func main() {
	h := sha1.New()
	_, err := io.WriteString(h, "His money is twice tainted:")
	if err != nil {
		log.Fatal("Error writing string to input")
	}
	_, err = io.WriteString(h, " 'taint yours and 'taint mine.")
	if err != nil {
		log.Fatal("Error writing string to input")
	}
	fmt.Printf("% x", h.Sum(nil))
}
