package main

import "fmt"

func main() {
	var nIt int
	fmt.Scanf("%d\n", &nIt)

	for i := 0; i < nIt; i++ {
		var length int
		fmt.Scanf("%d\n", &length)

		var sequence []int
		for j := 0; j < length; j++ {
			var value int
			fmt.Scanf("%d", &value)
			sequence = append(sequence, value)
		}
		fmt.Scanf("\n")

		result := sequence[0]
		for j := 0; j < length; j++ {
			result &= sequence[j]
		}
		fmt.Println(result)
	}
}
