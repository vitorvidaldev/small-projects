package main

import (
	"fmt"
	"log"
)

func main() {
	var s1, s2, output string
	getStringInput(s1)
	getStringInput(s2)
	getStringInput(output)

	if CanItBePermuted(s1, s2, output) {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}

func getStringInput(s string) {
	_, err := fmt.Scanf("%s\n", &s)
	if err != nil {
		log.Fatal(err)
	}
}

func CanItBePermuted(s1, s2, output string) (result bool) {
	input := s1 + s2
	inputMap := make(map[rune]int)
	for _, r := range input {
		inputMap[r]++
	}

	for _, r := range output {
		if inputMap[r] == 0 {
			return false
		}
		inputMap[r]--
	}

	for _, r := range input {
		if inputMap[r] != 0 {
			return false
		}
	}

	return true
}
