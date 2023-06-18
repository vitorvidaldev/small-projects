package app

import (
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

func Start() {
	router := mux.NewRouter()
	router.HandleFunc("/api/time", getTime).Methods(http.MethodGet)

	log.Fatal(http.ListenAndServe("localhost:8080", router))
}
