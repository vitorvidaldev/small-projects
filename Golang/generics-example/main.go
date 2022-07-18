package main

import "fmt"

// With generics, you can declare and use functions or types that are written to work with any of a set of types provided by calling code.

// SumIntsOrFloats sums the values of map m. It supports int64 and float64 as types for map values
func SumIntsOrFloats[K comparable, V int64 | float64](m map[K]V) V {
	var s V
	for _, v := range m {
		s += v
	}
	return s
}

func main() {
	// Initialize a map for the integer values
	ints := map[string]int64{
		"first":  34,
		"second": 12,
	}

	floats := map[string]float64{
		"first":  35.98,
		"second": 26.99,
	}

	fmt.Printf("Non-Generic Sums: %v and %v\n", SumIntsOrFloats(ints), SumIntsOrFloats(floats))
}
