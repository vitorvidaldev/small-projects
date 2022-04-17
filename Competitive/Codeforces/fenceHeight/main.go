package main

import "fmt"

func main() {
	var nFriends, fHeight int
	fmt.Scanf("%d %d\n", &nFriends, &fHeight)

	var friends []int
	for i := 0; i < nFriends; i++ {
		var input int
		fmt.Scanf("%d", &input)
		friends = append(friends, input)
	}

	var rowSize int
	for i := 0; i < nFriends; i++ {
		if friends[i] > fHeight {
			rowSize += 2
		} else {
			rowSize++
		}
	}

	fmt.Println(rowSize)
}
