package main

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/hex"
	"fmt"
)

func main() {
	secret := "my secret"
	data := "data"

	h := hmac.New(sha256.New, []byte(secret))

	h.Write([]byte(data))

	sha := hex.EncodeToString(h.Sum(nil))

	fmt.Println(sha)
}
