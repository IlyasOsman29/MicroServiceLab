# MicroServiceLab

This lab has a small Spring Boot service for the game score. `ScoreClient` calls it with `RestTemplate`.

The service supports:

- `GET /score` to read the score
- `POST /score/{points}` to add points
- `DELETE /score` to reset it

## Test

```text
mvn clean verify
```

The integration test starts the server on a random port and checks reset, add and read through the client.

## Try it manually

Start the server:

```text
mvn spring-boot:run
```

Then run this in another terminal:

```text
mvn -q exec:java -Dexec.mainClass=dk.sdu.cbse.score.ScoreClientDemo -Dexec.classpathScope=runtime
```
