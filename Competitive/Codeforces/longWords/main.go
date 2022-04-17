package main

import "fmt"

func main() {
	var n int
	_, err := fmt.Scanf("%d\n", &n)
	if err != nil {
		panic(err)
	}

	for i := 0; i < n; i++ {
		var s string
		_, err := fmt.Scanf("%s\n", &s)
		if err != nil {
			panic(err)
		}

		if len(s) <= 10 {
			fmt.Println(s)
		} else {
			fmt.Printf("%c%d%c\n", s[0], len(s)-2, s[len(s)-1])
		}
	}
}
