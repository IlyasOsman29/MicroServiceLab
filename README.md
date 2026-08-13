# MicroServiceLab - scoring service

This lab contains a small Spring Boot scoring microservice and an Asteroids-facing client that uses Spring `RestTemplate`.

## Automated integration proof

```powershell
mvn clean test package
```

`ScoreIntegrationTest` starts the real HTTP server on a random port. Through `ScoreClient` and `RestTemplate` it resets the score, adds 25 points, reads 25, adds 5 and reads 30. This proves network integration rather than only compiling a client beside a controller.

## Manual server/client demonstration

Terminal 1:

```powershell
mvn spring-boot:run
```

Terminal 2, after the server reports that it started:

```powershell
mvn -q exec:java -Dexec.mainClass=dk.sdu.cbse.score.ScoreClientDemo -Dexec.classpathScope=runtime
```

The client resets the server, adds points and prints the changed score. The REST API is:

- `GET /score` - read score
- `POST /score/{points}` - add points and return score
- `DELETE /score` - reset score
