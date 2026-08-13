package dk.sdu.cbse.score;

import org.springframework.web.client.RestTemplate;

/** Minimal Asteroids-side adapter for the remote scoring component. */
public final class ScoreClient {
    private final RestTemplate restTemplate;
    private final String scoreUrl;

    public ScoreClient(String baseUrl) { this(new RestTemplate(), baseUrl); }

    ScoreClient(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.scoreUrl = baseUrl.replaceAll("/$", "") + "/score";
    }

    public int get() {
        Integer value = restTemplate.getForObject(scoreUrl, Integer.class);
        return value == null ? 0 : value;
    }

    public int add(int points) {
        Integer value = restTemplate.postForObject(scoreUrl + "/" + points, null, Integer.class);
        return value == null ? 0 : value;
    }

    public void reset() { restTemplate.delete(scoreUrl); }
}
