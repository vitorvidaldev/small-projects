package main

import "fmt"

func main() {
	var c1, c2, c3, c4 int
	fmt.Scanf("%d %d %d %d\n", &c1, &c2, &c3, &c4)

	set := map[int]bool{c1: true, c2: true, c3: true, c4: true}

	fmt.Println(4 - len(set))
}
