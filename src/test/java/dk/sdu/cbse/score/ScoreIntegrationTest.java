package dk.sdu.cbse.score;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScoreIntegrationTest {
    @LocalServerPort private int port;

    @Test
    void restTemplateAddsAndReadsScoreThroughRealHttpServer() {
        ScoreClient client = new ScoreClient("http://localhost:" + port);
        client.reset();
        assertEquals(0, client.get());
        assertEquals(25, client.add(25));
        assertEquals(25, client.get());
        assertEquals(30, client.add(5));
        assertEquals(30, client.get());
    }
}
