
```javascript
mkdir dev-rabbitmq-producer
cd dev-rabbitmq-producer
```

Before we start adding code lets initiliase our project
```go
go mod init github.com/nuttydfgdf/dev-rabbitmq-producer
```

Create main.go file. and we will listen on port :8000 for web requests.
```go
package main

import (
	"io"
	"log"
	"net/http"
)

func main() {
	// Hello world, the web server

	helloHandler := func(w http.ResponseWriter, req *http.Request) {
		io.WriteString(w, "Hello, world!\n")
	}

	http.HandleFunc("/hello", helloHandler)


    log.Println("Listing for requests at http://localhost:8000/hello")
	log.Fatal(http.ListenAndServe(":8000", nil))
}
```

Now run this with the following command.

    go build
    go run main.go

This should print out a URL you can navigate to in your browser and see the classic.
Go to http://localhost:8000/hello

## The Go RabbitMQ client library
Next, install amqp using go get:

    go get github.com/rabbitmq/amqp091-go

create send.go and copy https://github.com/rabbitmq/rabbitmq-tutorials/blob/main/go/send.go to your file.


go build && ./services