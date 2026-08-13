package dk.sdu.cbse.score;

public final class ScoreClientDemo {
    private ScoreClientDemo() { }
    public static void main(String[] args) {
        String baseUrl = args.length == 0 ? "http://localhost:8080" : args[0];
        ScoreClient client = new ScoreClient(baseUrl);
        client.reset();
        System.out.println("Score after reset: " + client.get());
        System.out.println("Score after asteroid hit (+25): " + client.add(25));
        System.out.println("Score read from service: " + client.get());
    }
}
