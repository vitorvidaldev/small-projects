package main

import "fmt"

func main() {
	var nChildren, time int
	fmt.Scanf("%d %d\n", &nChildren, &time)

	var queue []byte
	fmt.Scanf("%s\n", &queue)
	for j := 0; j < time; j++ {
		var flag []bool
		flag = append(flag, false)
		for i := 1; i < nChildren; i++ {
			flag = append(flag, false)
			currChild := queue[i]
			lastChild := queue[i-1]
			if currChild == 'G' && lastChild == 'B' && flag[i-1] == false {
				queue[i] = lastChild
				queue[i-1] = currChild
				flag[i] = true
			}
		}
	}
	fmt.Println(string(queue))
}
