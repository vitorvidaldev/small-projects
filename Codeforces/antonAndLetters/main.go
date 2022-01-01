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

	result := make(map[byte]int)
	for i := 1; i < len(input)-1; i++ {
		if input[i] != ',' && input[i] != ' ' {
			result[input[i]]++
		}
	}
	fmt.Println(len(result))
}
