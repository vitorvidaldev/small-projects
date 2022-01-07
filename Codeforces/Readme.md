# Codeforces solutions

To run a solution, execute `go run main.go`

To test the solution, execute `go test` or `go test -v`

To verify the tests coverage, execute `got test -cover`

To generate a html coverage report, execute

```
go test -cover -coverprofile=c.out
go tool cover -html=c.out coverage.html
```
You can visualize the result in a browser