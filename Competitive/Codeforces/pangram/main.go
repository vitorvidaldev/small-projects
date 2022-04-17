package main

import (
	"fmt"
	"strings"
)

func main() {
	var stringSize int
	fmt.Scanf("%d\n", &stringSize)

	var stringInput string
	fmt.Scanf("%s\n", &stringInput)

	var alphabet = make(map[rune]bool)

	for _, char := range strings.ToLower(stringInput) {
		alphabet[char] = true
	}
	if len(alphabet) == 26 {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
