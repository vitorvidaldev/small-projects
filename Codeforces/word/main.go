package main

import (
	"fmt"
	"strings"
)

func main() {
	var s string
	fmt.Scanf("%s\n", &s)

	nLower := 0
	nUpper := 0

	for _, c := range s {
		if c >= 'a' && c <= 'z' {
			nLower++
		} else if c >= 'A' && c <= 'Z' {
			nUpper++
		}
	}

	if nLower >= nUpper {
		fmt.Println(strings.ToLower(s))
	} else {
		fmt.Println(strings.ToUpper(s))
	}
}
