package main

import "fmt"

func main() {
	var a, b int
	fmt.Scanf("%d %d", &a, &b)

	var nYears = NumberOfYears(a, b)

	fmt.Println(nYears)
}

func NumberOfYears(a, b int) (nYears int) {
	for {
		if a > b {
			break
		}
		a *= 3
		b *= 2
		nYears++
	}

	return nYears
}
