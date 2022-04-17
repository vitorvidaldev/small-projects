package main

import "fmt"

func main() {
	// integer command line input
	var numberProblems int
	fmt.Scanf("%d\n", &numberProblems)

	// 2d matrix with n rows and 3 columns
	var matrix [][]int
	for i := 0; i < numberProblems; i++ {
		var row []int
		for j := 0; j < 3; j++ {
			var number int
			fmt.Scanf("%d", &number)
			row = append(row, number)
		}
		fmt.Scanf("\n")
		matrix = append(matrix, row)
	}

	solved := 0
	for i := 0; i < numberProblems; i++ {
		if matrix[i][0]+matrix[i][1]+matrix[i][2] > 1 {
			solved++
		}
	}

	fmt.Println(solved)
}
