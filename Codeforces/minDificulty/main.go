package main

import "fmt"

func main() {
	// Array input
	var nHolds int
	fmt.Scanf("%d\n", &nHolds)

	var holds []int
	for i := 0; i < nHolds; i++ {
		var hold int
		fmt.Scanf("%d", &hold)
		holds = append(holds, hold)
	}
	fmt.Scanf("\n")

	var diffs = []int{}
	for i := 1; i < nHolds-1; i++ {
		newHolds := removeIndex(holds, i)
		diffs = append(diffs, maxDifficulty(newHolds))
	}

	fmt.Println(minElement(diffs))
}

// Creates new slice without element in index i
func removeIndex(s []int, i int) []int {
	tmp := make([]int, len(s))
	copy(tmp, s)
	return append(tmp[:i], tmp[i+1:]...)
}

// Returns minimum element in array
func minElement(diffs []int) int {
	var minDiff = 999999
	for _, diff := range diffs {
		if diff < minDiff {
			minDiff = diff
		}
	}
	return minDiff
}

func maxDifficulty(newHolds []int) int {
	maxDiff := 0
	for i := 1; i < len(newHolds); i++ {
		diff := newHolds[i] - newHolds[i-1]
		if diff > maxDiff {
			maxDiff = diff
		}
	}
	return maxDiff
}
