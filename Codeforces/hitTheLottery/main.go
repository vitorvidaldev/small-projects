package main

import "fmt"

func main() {
	var input int
	fmt.Scanf("%d\n", &input)

	var result int
	if input/100 >= 0 {
		result += input / 100
		input %= 100
	}
	if input/20 >= 0 {
		result += input / 20
		input %= 20
	}
	if input/10 >= 0 {
		result += input / 10
		input %= 10
	}
	if input/5 >= 0 {
		result += input / 5
		input %= 5
	}
	if input >= 0 {
		result += input
	}

	fmt.Println(result)
}
