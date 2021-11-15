package main

import "fmt"

func main() {
	it := 0
	fmt.Scanf("%d\n", &it)

	sum := 0

	for i := 0; i < it; i++ {
		var s string
		fmt.Scanf("%s\n", &s)

		a := ""
		// identify substring
		if s[0] == 'X' {
			a = s[1:]
		} else {
			a = s[:len(s)-1]
		}

		if a == "++" {
			sum++
		} else {
			sum--
		}
	}

	fmt.Println(sum)
}
