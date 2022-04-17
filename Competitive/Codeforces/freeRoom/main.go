package main

import "fmt"

func main() {
	var nRooms int
	fmt.Scanf("%d\n", &nRooms)

	var nFreeR int
	for i := 0; i < nRooms; i++ {
		var nLiving, capacity int
		fmt.Scanf("%d %d\n", &nLiving, &capacity)

		if capacity-nLiving >= 2 {
			nFreeR++
		}
	}

	fmt.Println(nFreeR)
}
