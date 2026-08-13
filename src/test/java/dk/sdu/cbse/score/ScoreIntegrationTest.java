package dk.sdu.cbse.score;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScoreIntegrationTest {
    @LocalServerPort private int port;

    @Test
    void asteroidsGameUpdatesScoreThroughRealHttpServer() {
        AsteroidsGame game = new AsteroidsGame(new ScoreClient("http://localhost:" + port));
        game.start();
        assertEquals(0, game.score());
        assertEquals(25, game.asteroidDestroyed());
        assertEquals(50, game.asteroidDestroyed());
        assertEquals(50, game.score());
    }
}
