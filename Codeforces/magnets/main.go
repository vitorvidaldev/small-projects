package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var nGroups int16
	var currentMagnet int8 = -1

	for i := 0; i < n; i++ {
		var magnet int8
		fmt.Scanf("%d\n", &magnet)
		if currentMagnet != magnet {
			nGroups++
			currentMagnet = magnet
		}
	}

	fmt.Println(nGroups)
}
