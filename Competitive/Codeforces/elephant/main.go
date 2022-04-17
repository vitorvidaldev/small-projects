package main

import "fmt"

func main() {
	var a int
	fmt.Scanf("%d", &a)

	steps := 0
	for a > 0 {
		if a >= 5 {
			a -= 5
			steps++
		} else if a == 4 {
			a -= 4
			steps++
		} else if a == 3 {
			a -= 3
			steps++
		} else if a == 2 {
			a -= 2
			steps++
		} else if a == 1 {
			a -= 1
			steps++
		}
	}

	fmt.Println(steps)
}
