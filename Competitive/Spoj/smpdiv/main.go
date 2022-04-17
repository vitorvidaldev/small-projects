package main

import "fmt"

func main() {
	var tCases int
	fmt.Scanf("%d\n", &tCases)

	var n, x, y int

	for i := 0; i < tCases; i++ {
		fmt.Scanf("%d %d %d\n", &n, &x, &y)

		for j := 1; j < n; j++ {
			if j%x == 0 && j%y != 0 {
				fmt.Printf("%d ", j)
			}
		}
		fmt.Println()
	}
}
