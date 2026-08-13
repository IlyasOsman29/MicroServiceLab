# MicroServiceLab

This lab has a small Spring Boot service for the game score. `ScoreClient` calls it with `RestTemplate`, and `AsteroidsGame` is the game-side class that resets the score and awards 25 points when an asteroid is destroyed.

This is the last separate exercise before the runtime plugin demonstration in [AsteroidsFinal](https://github.com/IlyasOsman29/AsteroidsFinal).

The service supports:

- `GET /score` to read the score
- `POST /score/{points}` to add points
- `DELETE /score` to reset it

## Test

```text
mvn clean verify
```

The integration test starts the server on a random port. It then starts the small Asteroids-side client, destroys two asteroids and checks that the service score changes from 0 to 25 and then 50.

## Try it manually

Start the server:

```text
mvn spring-boot:run
```

Then run this in another terminal:

```text
mvn -q exec:java -Dexec.mainClass=dk.sdu.cbse.score.ScoreClientDemo -Dexec.classpathScope=runtime
```
