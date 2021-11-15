package main

import "fmt"

func main() {
	var n int
	var s string
	fmt.Scanf("%d\n", &n)
	fmt.Scanf("%s\n", &s)

	var aCount, dCount int

	for _, c := range s {
		if c == 'A' {
			aCount++
		} else if c == 'D' {
			dCount++
		}
	}

	if aCount > dCount {
		fmt.Println("Anton")
	} else if dCount > aCount {
		fmt.Println("Danik")
	} else {
		fmt.Println("Friendship")
	}
}
