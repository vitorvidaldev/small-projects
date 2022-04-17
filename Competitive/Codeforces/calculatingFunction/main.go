package main

import (
	"fmt"
)

// f(n) = n
func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var result int

	if n%2 == 0 {
		result = n / 2
	} else {
		result = -((n / 2) + 1)
	}

	fmt.Println(result)
}
