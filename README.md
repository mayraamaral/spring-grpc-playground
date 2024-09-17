# Spring + gRPC playground
## Running
Open the terminal in the repository root folder, and then execute the following command:
```shell
./mvnw spring-boot:run
```
PS.: if you face permission issues, just run the command bellow, and then run the command above after again.
```shell
chmod +x mvnw
```
## Endpoints
`GET /greet` - this endpoint returns a personalized greeting message.
### Query parameters

| Parameter | Type   | Description                             |
| --------- | ------ | --------------------------------------- |
| `name`    | String | The name of the person to greet. (Required) |

### Request example
```bash
curl -X GET "http://localhost:8080/greet?name=Mayra"
```
### Response example
```json
{
  "greeting": "Hello, Mayra"
}
```

References:
- [Docs](https://grpc.io/docs/languages/java/basics/)
- [Baeldung's Introduction to gRPC with Spring Boot](https://www.baeldung.com/spring-boot-grpc)