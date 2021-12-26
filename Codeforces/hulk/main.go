package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	const hate = "I hate "
	const connect = "that "
	const love = "I love "
	const suffix = "it"

	var result string

	for i := 1; i <= n; i++ {
		if i == 1 {
			result += hate
		} else if i%2 == 0 {
			result += connect + love
		} else {
			result += connect + hate
		}
	}

	result += suffix
	fmt.Println(result)
}
