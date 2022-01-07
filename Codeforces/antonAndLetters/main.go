package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()

	input := scanner.Text()

	var result = FindSize(input)

	fmt.Println(result)
}

func FindSize(input string) (length int) {
	result := make(map[byte]int)
	for i := 1; i < len(input)-1; i++ {
		if input[i] != ',' && input[i] != ' ' {
			result[input[i]]++
		}
	}
	return len(result)
}
