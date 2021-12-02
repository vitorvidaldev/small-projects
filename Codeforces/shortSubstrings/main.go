package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	for i := 0; i < n; i++ {
		var s string
		fmt.Scanf("%s\n", &s)

		var substring byte
		var aux int
		var posArr []int
		for j := 1; j < len(s)-1; j++ {
			if j == 0 || s[j] != substring {
				substring = s[j]
				aux = 1
			} else if substring == s[j] {
				aux++
			}

			if aux == 2 {
				posArr = append(posArr, j)
				aux = 0
			}
		}
		for i := len(posArr) - 1; i >= 0; i-- {
			s = s[:posArr[i]] + s[posArr[i]+1:]
		}
		fmt.Println(s)
	}

}
