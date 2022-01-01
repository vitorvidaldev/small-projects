package main

import "fmt"

type Uniform struct {
	home  int
	guest int
}

func main() {
	var it int
	fmt.Scanf("%d\n", &it)

	uniforms := make(map[int]Uniform)

	for i := 0; i < it; i++ {
		var h, g int
		fmt.Scanf("%d %d\n", &h, &g)
		uniforms[i] = Uniform{h, g}
	}

	var result int
	for i := 0; i < it; i++ {
		for j := 0; j < it; j++ {
			if uniforms[i].home == uniforms[j].guest {
				result++
			}
		}
	}

	fmt.Println(result)
}
