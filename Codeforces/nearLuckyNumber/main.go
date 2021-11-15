package main

import "fmt"

func main() {
	var s string
	fmt.Scanf("%s\n", &s)

	var nLucky int
	for i := 0; i < len(s); i++ {
		if s[i] == '4' || s[i] == '7' {
			nLucky++
		}
	}
	if nLucky == 4 || nLucky == 7 {
		fmt.Println("YES")
	} else {
		fmt.Println("NO")
	}
}
