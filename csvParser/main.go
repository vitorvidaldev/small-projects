package main

import (
	"encoding/csv"
	"encoding/json"
	"fmt"
	"log"
	"os"
)

type User struct {
	Id       string `json:"_id"`
	Username string `json:"username"`
	Email    string `json:"email"`
}

type Obj struct {
	id   string
	resp []User
}

func main() {
	content := readCsv("./test.csv")
	for _, item := range content {
		fmt.Println(item)
	}
}

func readCsv(path string) []Obj {
	data, err := os.Open(path)
	if err != nil {
		log.Fatal("Unable to read input file "+path, err)
	}

	defer func(f *os.File) {
		err := f.Close()
		if err != nil {

		}
	}(data)

	reader := csv.NewReader(data)
	reader.Comma = ';'
	reader.LazyQuotes = true

	records, err := reader.ReadAll()
	if err != nil {
		log.Fatal("Unable to parse file as CSV for "+path, err)
	}

	var content []Obj
	for _, r := range records {
		var jsonBlob = []byte(r[1])
		var users []User
		err := json.Unmarshal(jsonBlob, &users)
		if err != nil {
			return nil
		}
		content = append(content, Obj{r[0], users})
	}
	return content
}
