package main

import "fmt"

func main() {
	var nJudges int
	fmt.Scanf("%d\n", &nJudges)

	isEasy := true
	for i := 0; i < nJudges; i++ {
		var opinion int
		fmt.Scanf("%d", &opinion)
		if opinion == 1 {
			isEasy = false
		}
	}

	if isEasy {
		fmt.Println("EASY")
	} else {
		fmt.Println("HARD")
	}
}
