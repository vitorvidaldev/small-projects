package main

import (
	"fmt"
)

func main() {
	var a, b string
	fmt.Scanf("%s\n", &a)
	fmt.Scanf("%s\n", &b)

	// keep leading zeros after xor
	for i := 0; i < len(a); i++ {
		if uint(a[i]) == uint(b[i]) {
			fmt.Print("0")
		} else {
			fmt.Print(1)
		}
	}
}
