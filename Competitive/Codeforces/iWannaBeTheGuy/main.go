package main

import "fmt"

func main() {
	var nLevels int
	fmt.Scanf("%d\n", &nLevels)

	set := make(map[int]bool)

	for i := 1; i <= nLevels; i++ {
		set[i] = false
	}

	var xNLevels int
	fmt.Scanf("%d", &xNLevels)
	for i := 0; i < xNLevels; i++ {
		var xInput int
		fmt.Scanf("%d", &xInput)
		set[xInput] = true
	}

	var yNLevels int
	fmt.Scanf("\n%d", &yNLevels)
	for i := 0; i < yNLevels; i++ {
		var yInput int
		fmt.Scanf("%d", &yInput)
		set[yInput] = true
	}

	for i := 1; i <= nLevels; i++ {
		if set[i] == false {
			fmt.Println("Oh, my keyboard!")
			return
		}
	}

	fmt.Println("I become the guy.")
}
