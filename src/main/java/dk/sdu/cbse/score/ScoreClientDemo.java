package dk.sdu.cbse.score;

public final class ScoreClientDemo {
    private ScoreClientDemo() { }
    public static void main(String[] args) {
        String baseUrl = args.length == 0 ? "http://localhost:8080" : args[0];
        AsteroidsGame game = new AsteroidsGame(new ScoreClient(baseUrl));
        game.start();
        System.out.println("Score after game start: " + game.score());
        System.out.println("Score after asteroid destroyed: " + game.asteroidDestroyed());
        System.out.println("Score read from service: " + game.score());
    }
}
