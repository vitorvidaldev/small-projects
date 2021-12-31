package main

import "fmt"

func main() {
	var it int64
	fmt.Scanf("%d\n", &it)

	for i := int64(0); i < it; i++ {
		var a, b int
		fmt.Scanf("%d %d\n", &a, &b)

		result := a % b
		if result == 0 {
			fmt.Println(result)
		} else {
			fmt.Println(b - result)
		}
	}
}
