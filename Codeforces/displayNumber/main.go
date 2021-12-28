package main

import (
	"fmt"
	"strconv"
)

func main() {
	var nTests int
	fmt.Scanf("%d\n", &nTests)

	m := map[int]int{2: 1, 3: 7}

	for i := 0; i < nTests; i++ {
		var num int
		fmt.Scanf("%d\n", &num)

		var value int = num
		result := ""
		var it = 0
		for value > 0 {
			it++
			if value%m[3] != 0 {
				result += strconv.Itoa(m[3])
				value %= m[3]
			} else {
				result += strconv.Itoa(m[2])
				value %= m[2]
			}
		}

		n := 0
		rune := make([]rune, len(result))
		for _, r := range result {
			rune[n] = r
			n++
		}
		rune = rune[0:n]
		// Reverse
		for i := 0; i < n/2; i++ {
			rune[i], rune[n-1-i] = rune[n-1-i], rune[i]
		}
		// Convert back to UTF-8.
		output := string(rune)
		fmt.Println(output)
	}
}
