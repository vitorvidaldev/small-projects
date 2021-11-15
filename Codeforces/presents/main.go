package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var presents []int
	var result []int
	for i := 0; i < n; i++ {
		var input int
		fmt.Scanf("%d", &input)
		presents = append(presents, input)
		result = append(result, 0)
	}

	for i := 0; i < n; i++ {
		result[presents[i]-1] = i + 1
	}

	for i := 0; i < n; i++ {
		fmt.Printf("%d ", result[i])
	}
}
