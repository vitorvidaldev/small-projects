package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var s string
	fmt.Scanf("%s\n", &s)

	sum := 0
	before := ' '
	for _, c := range s {
		if c == before {
			sum += 1
		}
		before = c
	}

	fmt.Println(sum)
}
