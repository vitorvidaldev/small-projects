package main

import (
	"fmt"
	"sort"
)

func main() {
	var s string
	fmt.Scanf("%s\n", &s)

	var numbers []int
	for _, c := range s {
		if c != '+' {
			numbers = append(numbers, int(c-'0'))
		}

	}

	sort.Ints(numbers)

	for i := 0; i < len(numbers); i++ {
		fmt.Printf("%d", numbers[i])
		if i != len(numbers)-1 {
			fmt.Printf("+")
		}
	}
}
