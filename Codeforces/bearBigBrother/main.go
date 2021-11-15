package main

import "fmt"

func main() {
	var a, b int
	fmt.Scanf("%d %d", &a, &b)

	var nYears int
	for {
		if a > b {
			break
		}
		a *= 3
		b *= 2
		nYears++
	}

	fmt.Println(nYears)
}
