package main

import "fmt"

func main() {
	var nCities, nRoads int
	fmt.Scanf("%d %d\n", &nCities, &nRoads)

	cityMap := make(map[int][]int)
	for i := 0; i < nRoads; i++ {
		var a, b int
		fmt.Scanf("%d %d\n", &a, &b)
		cityMap[a] = append(cityMap[a], b)
		cityMap[b] = append(cityMap[b], a)
	}

	fmt.Println(numberOfDisconnectedGraphs(cityMap))
}

func numberOfDisconnectedGraphs(cityMap map[int][]int) int {
	var visited = make(map[int]bool)

	nGraphs := 0
	for k := range cityMap {
		if visited[k] == false {
			dfs(k, cityMap, &visited)
			nGraphs++
		}
	}
	return nGraphs - 1
}

func dfs(source int, cityMap map[int][]int, visited *map[int]bool) {
	(*visited)[source] = true
	for _, road := range cityMap[source] {
		if (*visited)[road] == false {
			(*visited)[road] = true
			dfs(road, cityMap, visited)
		}
	}
}
