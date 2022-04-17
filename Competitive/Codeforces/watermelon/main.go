package main

import "fmt"

func main() {
	var n int
	_, err := fmt.Scanf("%d", &n)
	if err != nil {
		panic(err)
	}
	for i := 1; i < n/2+1; i++ {
		n1 := n - i
		if n1%2 == 0 && i%2 == 0 {
			fmt.Println("YES")
			return
		}
	}
	fmt.Println("NO")
}
