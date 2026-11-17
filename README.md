# Tourist Update API with Token Validation

## Requirements
- Java 17
- Maven 3.6+ (or use Maven support in your IDE)

## Run
1. Extract the ZIP.
2. Open the `tourist-token-validation` folder in IntelliJ IDEA or Spring Tool Suite.
3. Run `TouristTokenValidationApplication.java`.
4. Open Swagger UI: http://localhost:8080/swagger-ui/index.html

## API
- Method: `PUT`
- URL: `http://localhost:8080/tourists/1`
- Header: `Authorization: my-secret-token`
- Content-Type: `application/json`

Request body:
```json
{
  "name": "Sravya",
  "city": "Hyderabad",
  "budget": 25000
}
```

A successful request returns the updated Tourist JSON. An invalid token returns HTTP 401.
A missing tourist ID returns HTTP 404.

## Important: Add a sample tourist before updating
The in-memory H2 database starts empty. Open the H2 console at
http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:touristdb`, user: `sa`,
blank password) and run:

```sql
INSERT INTO TOURIST (ID, NAME, CITY, BUDGET)
VALUES (1, 'Ravi', 'Chennai', 15000);
```

Then call the PUT endpoint in Swagger UI.

## Demo token note
`my-secret-token` is a hard-coded demonstration token so the exercise is easy to run.
It is not JWT authentication and must not be used in production. Use Spring Security
and signed JWT validation for a real application.
