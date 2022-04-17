package main

import "fmt"

func main() {
	var year int
	fmt.Scanf("%d\n", &year)

	for {
		year += 1
		s := fmt.Sprintf("%d", year)
		hasSameCharacter := false
		for i := 0; i < len(s); i++ {
			for j := i + 1; j < len(s); j++ {
				if s[i] == s[j] {
					hasSameCharacter = true
				}
			}
		}
		if !hasSameCharacter {
			fmt.Println(year)
			return
		}
		hasSameCharacter = false
	}

}
