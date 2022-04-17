package main

import "fmt"

func main() {
	var length int
	var filename string

	fmt.Scanf("%d\n", &length)
	fmt.Scanf("%s\n", &filename)

	x := 0
	count := 0
	for _, r := range filename {
		if r == 'x' {
			x++
			if x >= 3 {
				count++
			}
		} else if x != 0 {
			x = 0
		}
	}

	fmt.Println(count)
}
