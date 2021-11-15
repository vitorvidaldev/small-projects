package main

import (
	"fmt"
	"math"
)

func main() {
	var matrix [5][5]int

	rowPostion := 0
	columnPosition := 0
	for i := 0; i < 5; i++ {
		for j := 0; j < 5; j++ {
			input := 0
			fmt.Scanf("%d", &input)
			matrix[i][j] = input

			if input == 1 {
				rowPostion = i
				columnPosition = j
			}
		}
		fmt.Scanf("\n")
	}

	result := math.Abs(2-float64(rowPostion)) + math.Abs(2-float64(columnPosition))
	fmt.Println(result)
}
