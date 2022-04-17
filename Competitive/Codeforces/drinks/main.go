package main

import "fmt"

func main() {
	var nDrinks int
	fmt.Scanf("%d\n", &nDrinks)
	var nVolOrange []int
	for i := 0; i < nDrinks; i++ {
		var nVol int
		fmt.Scanf("%d", &nVol)
		nVolOrange = append(nVolOrange, nVol)
	}

	porcentage := 100.0 / float64(nDrinks)

	var totalVol float64 = 0
	for i := 0; i < nDrinks; i++ {
		totalVol += float64(nVolOrange[i]) * porcentage
	}

	fmt.Println(totalVol / 100)

}
