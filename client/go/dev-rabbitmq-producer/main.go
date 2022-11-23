package main

import (
	"io"
	"log"
	"net/http"

	"services"
)

func main() {
	// Hello world, the web server

	helloHandler := func(w http.ResponseWriter, req *http.Request) {
		io.WriteString(w, "Hello, world!\n")
	}

	http.HandleFunc("/hello", helloHandler)

	helloHandler2 := func(w http.ResponseWriter, req *http.Request) {
		//S.Send()
		io.WriteString(w, "Hello, world!\n")
	}

	http.HandleFunc("/hello2", helloHandler2)


    log.Println("Listing for requests at http://localhost:8000/hello")
	log.Fatal(http.ListenAndServe(":8000", nil))
}