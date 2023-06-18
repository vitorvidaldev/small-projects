package app

import (
	"encoding/json"
	"net/http"
	"strings"
	"time"
)

func getTime(w http.ResponseWriter, r *http.Request) {
	response := make(map[string]string, 0)
	tz := r.URL.Query().Get("tz")
	timezones := strings.Split(tz, ",")

	if len(timezones) == 0 {
		w.WriteHeader(http.StatusNotFound)
		w.Write([]byte("Timezone not found"))
	}

	for _, timezone := range timezones {
		loc, err := time.LoadLocation(timezone)
		if err != nil {
			w.WriteHeader(http.StatusBadRequest)
			w.Write([]byte("Invalid timezone"))
		}

		now := time.Now().In(loc)
		response[timezone] = now.String()
	}
	w.Header().Add("Content-Type", "application/json")
	json.NewEncoder(w).Encode(response)
}
