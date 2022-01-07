package main

import "testing"

func TestNumberOfYears(t *testing.T) {
	var input = []struct {
		lWeight int
		bWeight int
		nYears  int
	}{
		{4, 7, 2},
		{4, 9, 3},
		{1, 1, 1},
	}

	for _, test := range input {
		if NumberOfYears(test.lWeight, test.bWeight) != test.nYears {
			t.Fatal("Error")
		}
	}
}
