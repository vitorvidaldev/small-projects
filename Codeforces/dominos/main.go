package main

import (
	"fmt"
	"math"
)

func main() {
	a := 0
	b := 0
	fmt.Scanf("%d %d\n", &a, &b)

	fmt.Println(math.Floor(float64(a*b) * 0.5))
}
