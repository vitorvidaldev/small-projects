package main

import "fmt"

func main() {
	a := 0
	b := 0
	fmt.Scanf("%d %d\n", &a, &b)

	var arr []int
	for i := 0; i < a; i++ {
		var x int
		fmt.Scanf("%d", &x)
		arr = append(arr, x)
	}
	fmt.Scanf("\n")

	highScore := arr[b-1]
	sum := 0
	for i := 0; i < a; i++ {
		if arr[i] >= highScore && arr[i] > 0 {
			sum++
		}
	}

	fmt.Println(sum)
}
