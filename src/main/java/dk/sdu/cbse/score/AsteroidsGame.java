package dk.sdu.cbse.score;

/** Small game-side example that sends score changes to the score service. */
public final class AsteroidsGame {
    private static final int ASTEROID_POINTS = 25;
    private final ScoreClient scores;

    public AsteroidsGame(ScoreClient scores) {
        this.scores = scores;
    }

    public void start() {
        scores.reset();
    }

    public int asteroidDestroyed() {
        return scores.add(ASTEROID_POINTS);
    }

    public int score() {
        return scores.get();
    }
}
