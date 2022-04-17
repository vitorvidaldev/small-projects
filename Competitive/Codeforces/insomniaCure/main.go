package main

import "fmt"

func main() {
	var k, l, m, n, d int
	fmt.Scanf("%d\n%d\n%d\n%d\n%d\n", &k, &l, &m, &n, &d)

	damaged := 0
	for i := 1; i <= d; i++ {
		if i%k == 0 || i%l == 0 || i%m == 0 || i%n == 0 {
			damaged++
		}
	}

	fmt.Println(damaged)
}
