package main

import "fmt"

func main() {
	var it int
	fmt.Scanf("%d\n", &it)

	var heights []int
	for i := 0; i < it; i++ {
		var h int
		fmt.Scanf("%d", &h)
		heights = append(heights, h)
	}

	var result = FormLineUp(it, heights)

	fmt.Println(result)
}

func FormLineUp(it int, heights []int) (result int) {
	var maxIndex, minIndex int
	max := heights[0]
	min := heights[0]
	for i := 0; i < it; i++ {
		if heights[i] > max {
			max = heights[i]
			maxIndex = i
		}
		if heights[i] <= min {
			min = heights[i]
			minIndex = i
		}
	}

	result = it - 1 - minIndex + maxIndex

	if minIndex < maxIndex {
		result--
	}

	return result
}
