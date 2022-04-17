package main

import "fmt"

func main() {
	var number, nOperations int
	fmt.Scanf("%d %d\n", &number, &nOperations)

	for i := 0; i < nOperations; i++ {
		if number%10 == 0 {
			number /= 10
		} else {
			number--
		}
	}

	fmt.Println(number)
}
