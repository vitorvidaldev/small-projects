package main

import "testing"

func TestFindSize(t *testing.T) {
	var input = []struct {
		letter string
		size   int
	}{
		{"{a, b, c}", 3},
		{"{b, a, b, a}", 2},
		{"{}", 0},
	}

	for _, test := range input {
		var result = FindSize(test.letter)
		if result != test.size {
			t.Fatal("Error")
		}
	}
}
