package main

import "fmt"

func main() {
	var w1, w2 string
	fmt.Scanf("%s\n%s\n", &w1, &w2)

	reverseW2 := ""
	for i := len(w2) - 1; i >= 0; i-- {
		reverseW2 += string(w2[i])
	}

	if w1 == reverseW2 {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
