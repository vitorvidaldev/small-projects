package main

import (
	"fmt"
	"strings"
)

func main() {
	var s1 string
	var s2 string
	fmt.Scanf("%s\n", &s1)
	fmt.Scanf("%s\n", &s2)
	// make inputs lowercase
	s1 = strings.ToLower(s1)
	s2 = strings.ToLower(s2)

	result := 0
	for i := 0; i < len(s1); i++ {
		if s1[i] < s2[i] {
			result = -1
			break
		} else if s1[i] > s2[i] {
			result = 1
			break
		} else {
			result = 0
		}
	}

	fmt.Println(result)
}
