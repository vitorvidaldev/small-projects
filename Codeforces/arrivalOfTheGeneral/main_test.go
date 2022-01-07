package main

import "testing"

func TestFormLineUp(t *testing.T) {
	var input = []struct {
		nSoldiers int
		heights   []int
		output    int
	}{
		{4, []int{33, 44, 11, 22}, 2},
		{7, []int{10, 10, 58, 31, 63, 40, 76}, 10},
	}

	for _, test := range input {
		if FormLineUp(test.nSoldiers, test.heights) != test.output {
			t.Fatal("Error")
		}
	}
}
