package main

import "fmt"

func main() {
	var nStops int
	fmt.Scanf("%d\n", &nStops)

	var minCapacity int
	var currCapacity int

	for i := 0; i < nStops; i++ {
		var out, in int
		fmt.Scanf("%d %d\n", &out, &in)
		currCapacity += in - out
		if currCapacity < 0 {
			currCapacity = 0
		}
		if currCapacity > minCapacity {
			minCapacity = currCapacity
		}
	}

	fmt.Println(minCapacity)
}
