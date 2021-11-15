package main

import (
	"fmt"
)

func main() {
	var s string
	fmt.Scanf("%s\n", &s)

	if s[0] >= 'a' && s[0] <= 'z' {
		s = string(s[0]-32) + s[1:]
	}
	fmt.Println(s)
}
