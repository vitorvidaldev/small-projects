package main

import "fmt"

func main() {
	var s1, s2, output string
	fmt.Scanf("%s\n", &s1)
	fmt.Scanf("%s\n", &s2)
	fmt.Scanf("%s\n", &output)

	input := s1 + s2
	inputMap := make(map[rune]int)
	for _, r := range input {
		inputMap[r]++
	}

	for _, r := range output {
		if inputMap[r] == 0 {
			fmt.Println("NO")
			return
		}
		inputMap[r]--
	}

	for _, r := range input {
		if inputMap[r] != 0 {
			fmt.Println("NO")
			return
		}
	}

	fmt.Println("YES")
}
