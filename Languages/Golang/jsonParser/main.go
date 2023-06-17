package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
)

type Planet struct {
	Name              string  `json:"planet_name"`
	NameDescription   string  `json:"planet_name_description"`
	DistSunAU         float64 `json:"dist_sun_au"`
	DiameterKm        float64 `json:"diameter_km"`
	NumMoons          int8    `json:"num_moons"`
	YearLengthInDays  float64 `json:"year_length_in_days"`
	PlanetType        string  `json:"planet_type"`
	PlanetDescription string  `json:"planet_description"`
}

func main() {
	planets := readFile("planets.json")

	for _, planet := range planets {
		fmt.Println(planet)
	}
}

func readFile(filePath string) []Planet {
	file, err := ioutil.ReadFile(filePath)
	if err != nil {
		log.Fatal("Cannot read file from path provided ", err)
	}

	var data []Planet
	err = json.Unmarshal(file, &data)
	if err != nil {
		log.Fatal("Cannot unmarshal json object ", err)
	}

	return data
}
