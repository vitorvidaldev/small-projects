package main

import "fmt"

func main() {
	var s1, s2, output string
	fmt.Scanf("%s\n", &s1)
	fmt.Scanf("%s\n", &s2)
	fmt.Scanf("%s\n", &output)

	if CanItBePermutted(s1, s2, output) {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}

func CanItBePermutted(s1, s2, output string) (result bool) {
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
