package main

import "fmt"

func main() {
	var k, n, w int
	fmt.Scanf("%d %d %d", &k, &n, &w)

	totalValue := 0
	for i := 1; i <= w; i++ {
		totalValue += i * k
	}

	res := totalValue - n

	if res < 0 {
		res = 0
	}

	fmt.Println(res)
}
