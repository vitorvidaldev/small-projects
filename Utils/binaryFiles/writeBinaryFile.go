package main

import (
	"encoding/binary"
	"fmt"
	"os"
)

func WriteHeader(outf *os.File) {
	fheader := []byte("P6\n")
	binary.Write(outf, binary.LittleEndian, fheader)

	fheader2 := []byte("640 480\n")
	binary.Write(outf, binary.LittleEndian, fheader2)

	fheader3 := []byte("255\n")
	binary.Write(outf, binary.LittleEndian, fheader3)
}

func main() {
	outf, _ := os.Create("test.bin")

	WriteHeader(outf)

	for i := 0; i < 50; i++ {
		var ii uint8 = uint8(i)
		err := binary.Write(outf, binary.LittleEndian, ii)
		if err != nil {
			fmt.Println("err!", err)
		}
	}

	outf.Close()
}
