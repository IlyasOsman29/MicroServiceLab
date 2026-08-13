package dk.sdu.cbse.score;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ScoreController {
    private final AtomicInteger score = new AtomicInteger();

    @GetMapping("/score")
    public int get() { return score.get(); }

    @PostMapping("/score/{points}")
    public int add(@PathVariable int points) { return score.addAndGet(points); }

    @DeleteMapping("/score")
    public void reset() { score.set(0); }
}
