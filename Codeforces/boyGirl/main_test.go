package main

import "testing"

func TestHasEventDistinctCharacters(t *testing.T) {
	var input = []struct {
		username string
		res      bool
	}{
		{"wjmzbmr", true},
		{"xiaodao", false},
		{"sevenkplus", true},
	}

	for _, test := range input {
		if HasEvenDistinctCharacters(test.username) != test.res {
			t.Fatal("Error")
		}
	}
}
